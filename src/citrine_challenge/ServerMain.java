package citrine_challenge;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ServerMain {
    public static void main(String[] args) throws IOException {        
        final int port=8080;
        new WebServer(port).start();
    }
}
