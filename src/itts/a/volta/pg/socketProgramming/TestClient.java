package itts.a.volta.pg.socketProgramming;

public class TestClient {
	
	public static void main(String[] args) {
		
		Client client = new Client();
		client.connect();
		client.comunication();
		client.close();
				
	}
	
}