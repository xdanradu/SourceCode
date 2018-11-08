import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionManager extends Thread {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public ConnectionManager(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void run() {
		try {
			String receivedMessage = "";
			while (!receivedMessage.equals("STOP")) {
				receivedMessage = in.readLine();
				System.out.println("Connection Mannager Thread (id: " + this.getId() + ") REC >> " + receivedMessage);
				out.println("Message from Thread (id: " + this.getId() + ") ACK for: " + receivedMessage);
			}
			in.close();
			out.close();
			socket.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}