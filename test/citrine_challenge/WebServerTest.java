package citrine_challenge;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;

import org.json.JSONObject;

class WebServerTest {

    @Test void test() throws IOException {
        WebServer server = new WebServer(0);
        JSONObject obj = server.convertUnits("(degree/minute)");
        assertEquals(obj.toString(), "{\"unit_name\":\"(rad/s)\",\"multiplication_factor\":0.00029088820866572}");
    }
    
    @Test
    public void testAssertionsEnabled() {
        assertThrows(AssertionError.class, () -> { assert false; },
                "make sure assertions are enabled with VM argument '-ea'");
    }
    
    public void testIO(String units, String output) throws IOException, URISyntaxException {
        units = URLEncoder.encode(units, "UTF-8");
        final WebServer server = new WebServer(0);
        server.start();
        
        final URL valid = new URL("http://localhost:" + server.port() + "/units/si?units=" + units);
        
        // in this test, we will just assert correctness of the server's output
        final InputStream inputstream = valid.openStream();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream, UTF_8));
        assertEquals(output, reader.readLine());
        assertEquals(null, reader.readLine(), "end of stream");
        server.stop();
    }
    
    @Test
    public void testUnitSI() throws IOException, URISyntaxException {
        testIO("(rad)","{\"unit_name\":\"(rad)\",\"multiplication_factor\":1}");
        testIO("(degree/minute)","{\"unit_name\":\"(rad/s)\",\"multiplication_factor\":0.00029088820866572}");
    }
    
    @Test
    public void testSpecialCharacters() throws IOException, URISyntaxException {
        testIO("(m^2)","{\"unit_name\":\"(m^2)\",\"multiplication_factor\":1}");
        testIO("(')","{\"unit_name\":\"(rad)\",\"multiplication_factor\":0.00029088820866572}");
        testIO("(\")","{\"unit_name\":\"(rad)\",\"multiplication_factor\":0.0000048481368110954}");
    }
    
    
    public void testIOInvalid(String units) throws IOException, URISyntaxException {
        final WebServer server = new WebServer(0);
        server.start();
        
        final URL invalid = new URL("http://localhost:" + server.port() + units);
        
        final HttpURLConnection connection = (HttpURLConnection) invalid.openConnection();
        assertEquals(404, connection.getResponseCode(), "response code");
        server.stop();
    }
    
    @Test
    public void testUnitSIInvalid() throws IOException, URISyntaxException{
        testIOInvalid("/units/si?test=abc");
        testIOInvalid("/units/ghc");
    }

}
