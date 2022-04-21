package itts.a.volta.pg.socketProgramming;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server implements Runnable{

	ServerSocket server = null;
    Socket client = null;
    int port = 9367;

    DataOutputStream out;
    Scanner scanner;

    public Socket listen() {
    	
        try {
            server = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            client = server.accept();
            scanner = new Scanner(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }
    
    public void comunication() {
    	
    	try {
    		String msg = scanner.nextLine();
    		String response = msg.toUpperCase();
    		out.writeBytes("Response from the server: '" + response + "'.\n");
    	}

    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void close() {
    	try {
			client.close();
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public void run() {
		listen();
		comunication();
		close();
	}
}