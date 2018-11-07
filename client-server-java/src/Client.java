import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{
	
	private final String HOST_NAME;
	private final int PORT;
	private String message;
	
	public Client(String hostName, int port, String message) {
		this.PORT=port;
		this.HOST_NAME = hostName;
		this.message = message;
	}

	public void run() {
		try {
			Socket socket = new Socket(this.HOST_NAME, this.PORT);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			String line = "";
			out.println(this.message);
			line = in.readLine();
			System.out.println("Client (id:"+this.getId()+") RECEIVED >> "+line);
			out.println("STOP");
			line = in.readLine();
			System.out.println("Client (id:"+this.getId()+") RECEIVED >> "+line);
		} catch (Exception ex) {
		}
	}
}
