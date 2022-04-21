package itts.a.volta.pg.socketProgramming;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client implements Runnable{
	
	int port = 9367;
	DataOutputStream out;
	Socket server = null;
	Scanner scanner = new Scanner(System.in);
	Scanner inputStreamScanner;
	
	public Socket connect() {
		
		try {
			
			System.out.println("Connecting to the server...");
			Thread.sleep(2000);
			server = new Socket(InetAddress.getLocalHost(), port);
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
		
		return server;
		
	}
	
	public void comunication() {
		System.out.println("Write in the message: ");
		String msg = scanner.nextLine();
		try {
			out.writeBytes(msg + "\n");
			String response = inputStreamScanner.nextLine();
			System.out.println(response);
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
	}
}