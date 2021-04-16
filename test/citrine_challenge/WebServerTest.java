package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;

class WebServerTest {

    @Test void test() throws IOException {
        WebServer server = new WebServer();
        JSONObject obj = server.ConvertUnits("(degree/minute)");
        assertEquals(obj.toString(), "{\"unit_name\":\"(rad\\/s)\",\"multiplication_factor\":0.00029088820866572}");
    }

}
