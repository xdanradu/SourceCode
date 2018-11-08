import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	private final int PORT;
	private ServerSocket serverSocket;

	public Server(int port) {
		this.PORT = port;
		try {
			serverSocket = new ServerSocket(this.PORT);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void run() {

		try {
			while (true) {
				System.out.println("Server Thread (id: " + this.getId() + ") is waiting for connections");
				Socket socket = null;
				socket = serverSocket.accept();
				ConnectionManager connection = new ConnectionManager(socket);
				System.out.println("Server Thread (id: " + this.getId()
						+ ") is starting a Connection Manager Thread (id: " + connection.getId() + ")");
				connection.start();
			}

		} catch (Exception ex1) {
			System.out.println(ex1.getMessage());
		} finally {
			try {
				serverSocket.close();
			} catch (IOException ex2) {
				System.out.println(ex2.getMessage());
			}
		}
	}

}
