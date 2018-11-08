import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{
		
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private final String HOST_NAME;
	private final int PORT;
	private String messageToSend;
	
	public Client(String hostName, int port, String message) {
		this.PORT = port;
		this.HOST_NAME = hostName;
		this.messageToSend = message;
		try {
			socket = new Socket(this.HOST_NAME, this.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);	
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
	}

	public void run() {

		try {
			out.println(this.messageToSend);
			String receivedMessage = "";
			receivedMessage = in.readLine();
			System.out.println("Client (id:"+this.getId()+") REC >> "+receivedMessage);
			out.println("STOP");
			receivedMessage = in.readLine();
			System.out.println("Client (id:"+this.getId()+") REC >> "+receivedMessage);			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
