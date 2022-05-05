package itts.a.volta.pg.socketProgramming;

import java.io.*;
import java.net.*;

public class Server {

	ServerSocket server = null;
    Socket client = null;
    int port = 9367;
    
    public Socket server() {
    	
        try {
            server = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            client = server.accept();
            ClientHandler cl = new ClientHandler(client);
            new Thread(cl).start();
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }
}