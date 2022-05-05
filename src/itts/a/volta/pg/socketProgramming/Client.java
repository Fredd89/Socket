package itts.a.volta.pg.socketProgramming;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	
	int port = 9367;
	DataOutputStream out;
	Socket server = null;
	Scanner scanner = new Scanner(System.in);
	Scanner inputStreamScanner;
	
	public Socket connect() {
		
		try {
			
			System.out.println("Connecting to the server...");
			server = new Socket(InetAddress.getLocalHost(), port);
			System.out.println("Connected!");
			inputStreamScanner = new Scanner(server.getInputStream());
			out = new DataOutputStream(server.getOutputStream());
			
		}
		
		catch (ConnectException e) {
			System.out.println("Website does not exists.");
			System.exit(0);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return server;
		
	}
	
	public void comunication() {
		System.out.println("Write in the message: ");
		String msg = "";
		Boolean bool = true;
    	while(bool) {
    		try {
    			msg = scanner.nextLine();
    			bool = !msg.equals("Exit");
    			out.writeBytes(msg + "\n");
    			String response = inputStreamScanner.nextLine();
    			System.out.println("Server: " + response + "\n");
    		}
    		
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	try {
			server.close();
		}
    	catch (IOException e) {
			e.printStackTrace();
		}
	}
}