package citrine_challenge;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {        
        int port;
        
        try {
            port = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            port = 8080;
        }
        new WebServer(port).start();
    }
}
