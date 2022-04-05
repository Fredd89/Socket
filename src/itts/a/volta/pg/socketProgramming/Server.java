package itts.a.volta.pg.socketProgramming;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {

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
            Thread.sleep(2000);
            System.out.println("Connection established.");
            Thread.sleep(2000);

            scanner = new Scanner(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        }
        
        catch (InterruptedException e) {
			e.printStackTrace();
		}
        catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }
    
    public void comunication() {
    	
    	try {
    		System.out.println("Waiting for a message from the client...");
    		String msg = scanner.nextLine();
    		Thread.sleep(2000);
    		System.out.println("Message recived, elaborating...");
    		Thread.sleep(2000);
    		String response = msg.toUpperCase();
    		System.out.println("Sending message...");
    		Thread.sleep(2000);
    		out.writeBytes("Response from the server: '" + response + "'.\n");
    		System.out.println("Message sent.");
    		Thread.sleep(1000);
    		client.close();
    	}
    	catch (InterruptedException e) {
			e.printStackTrace();
		}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }
	
	public static void main(String[] args) {
		
		Server server = new Server();
		server.listen();
		server.comunication();
		
	}

}