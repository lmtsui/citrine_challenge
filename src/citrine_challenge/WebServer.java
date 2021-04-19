package citrine_challenge;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Modified from https://github.mit.edu/6031-fa20/ps4/blob/main/src/memory/WebServer.java
 * @author lt
 *
 */
public class WebServer {
    
    private final HttpServer server;
    
    /**
     * Make a new web server that listens for connections on port.
     * 
     * @param port server port number
     * @throws IOException if an error occurs starting the server
     */
    public WebServer(int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // handle concurrent requests with multiple threads
        server.setExecutor(Executors.newCachedThreadPool());     
        HttpContext units = server.createContext("/units/", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                handleUnits(exchange);
            }
        });
    }
    
    private void handleUnits(HttpExchange exchange) throws IOException {
        final String path = exchange.getRequestURI().getPath();
        final String base = exchange.getHttpContext().getPath();
        final String subpath = path.substring(base.length());
        final String query = exchange.getRequestURI().getQuery();
        String response;
        if (query==null) {
            exchange.sendResponseHeaders(404, 0);
            response = "invalid URL";
        }else {
            final Map<String,String> queryMap = getQueryMap(query);
            
            if (!subpath.equals("si") | !queryMap.containsKey("units")) {
                exchange.sendResponseHeaders(404, 0);
                response = "invalid URL";
            }else {
                final String units = queryMap.get("units");
                
                exchange.sendResponseHeaders(200, 0);
                response = convertUnits(units).toString();
            }
        }
        
        OutputStream body = exchange.getResponseBody();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(body, UTF_8), true);
        out.println(response);
        
        exchange.close();
    }
    
    //https://stackoverflow.com/questions/4128436/query-string-manipulation-in-java
    public static Map<String, String> getQueryMap(String query)  
    {  
        String[] params = query.split("&");  
        Map<String, String> map = new HashMap<String, String>();  
        for (String param : params)  
        {  
            String name = param.split("=")[0];  
            String value = param.split("=")[1];  
            map.put(name, value);  
        }  
        return map;  
    }  
    
    /**
     * Convert a units string into a conversion object. 
     * Only one thread can be converting at a time.
     * 
     * @param units Properly formatted unit string, as defined in prompt.pdf
     * @return conversion Conversion object, as specified in prompt.pdf
     */
    public synchronized Conversion convertUnits(String units) {
        Expression expr = Expression.parse(units);
        String stringSI = expr.toStringSI();
        Double factor = expr.getFactor(); 
        BigDecimal bd = new BigDecimal(factor);
        BigDecimal factor14sf = bd.round(new MathContext(14)); // convert to 14 significant figures
        Conversion conversion = new Conversion(stringSI, factor14sf);
        return conversion;
    }

    /**
     * @return the port on which this server is listening for connections
     */
    public int port() {
        return server.getAddress().getPort();
    }
        
    /**
     * Start this server.
     */
    public void start() {
        System.err.println("Server will listen on " + server.getAddress());
        server.start();
    }
    
    /**
     * Stop this server.
     */
    public void stop() {
        System.err.println("Server will stop");
        server.stop(0);
    }
}
