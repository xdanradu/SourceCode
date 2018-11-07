import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	private final int PORT;
	
	public Server(int port){
		this.PORT = port;
	}
	
	public void run(){
		ServerSocket s = null;
		try {
			s = new ServerSocket(PORT);
			while (true){	
				System.out.println("Server Thread (id: "+this.getId()+ ") is waiting for connections");
				Socket socket = null;
				socket = s.accept();
				ConnectionManager connection = new ConnectionManager(socket);
				System.out.println("Server Thread (id: "+this.getId()+ ") is starting a Connection Manager Thread (id: "+connection.getId()+")");
				connection.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				s.close();
			} catch (IOException ex2) {
			}
		}
	}
	
}
