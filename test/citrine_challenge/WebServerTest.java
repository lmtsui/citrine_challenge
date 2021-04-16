package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;

class WebServerTest {

    @Test void test() throws IOException {
        WebServer server = new WebServer();
        JSONObject obj = server.ConvertUnits("(degree/minute)");
        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        
        String jsonText = out.toString();
        System.out.print(jsonText);
    }

}
