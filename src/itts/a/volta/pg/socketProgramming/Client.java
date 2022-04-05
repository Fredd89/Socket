package itts.a.volta.pg.socketProgramming;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	
	int port = 9367;
	DataOutputStream out;
	Socket mySocket = null;
	Scanner scanner = new Scanner(System.in);
	Scanner inputStreamScanner;
	
	public Socket connect() {
		
		try {
			
			System.out.println("Connecting to the server...");
			Thread.sleep(2000);
			Socket server = new Socket(InetAddress.getLocalHost(), port);
			System.out.println("Connected!");
			Thread.sleep(5000);
			inputStreamScanner = new Scanner(server.getInputStream());
			out = new DataOutputStream(server.getOutputStream());
			
		}
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (ConnectException e) {
			System.out.println("Website does not exists.");
			System.exit(0);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return mySocket;
		
	}
	
	public void comunication() {
		System.out.println("Write in the message: ");
		String msg = scanner.nextLine();
		try {
			System.out.println("Waiting for the message to be sent...");
			Thread.sleep(2000);
			out.writeBytes(msg + "\n");
			System.out.println("Message sent.\nWaiting for a response from the server...");
			String response = inputStreamScanner.nextLine();
			Thread.sleep(1500);
			System.out.println(response);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Client client = new Client();
		client.connect();
		client.comunication();
				
	}
}