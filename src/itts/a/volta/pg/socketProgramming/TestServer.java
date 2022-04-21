package itts.a.volta.pg.socketProgramming;

public class TestServer {
	
	public static void main(String[] args) {
		
		Server server = new Server();
		Thread thread = new Thread(server);
		thread.start();
		
	}
	
}