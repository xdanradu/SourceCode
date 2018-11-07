import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionManager extends Thread {

	Socket socket;
	BufferedReader in;
	PrintWriter out;

	public ConnectionManager(Socket s) {
		this.socket = s;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
		} catch (Exception ex) {
		}
	}

	public void run() {
		try {
			String line = "";
			while(line!="STOP"){
				line = in.readLine();
				if(line!="STOP"){
					System.out.println("Connection Mannager Thread (id: "+this.getId()+") RECEIVED >> "+line);
					out.println("Message from Thread (id: "+this.getId()+") ACK for: "+line);
				} else {
					in.close();
					out.close();
					socket.close();
				}	
			}
		} catch (Exception ex) {
		}

	}
}