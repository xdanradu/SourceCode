public class App {

	public static void main(String[] args) {
		
		Component b=new Component("B", "localhost", 4242);
		b.startServer();
		
		Component c=new Component("C", "localhost", 4243);
		c.startServer();
		
		Component a=new Component("A", "localhost", 2000);
		
		a.sendMessageTo(b, "Message 1 from A to B");
		b.sendMessageTo(c, "Message from B to C");
		a.sendMessageTo(b, "Message 2 from A to B");
		c.sendMessageTo(b, "Message from C to B");

	}
	
}
