public class Component {
	
	private final int HOST_PORT;
	private final String HOST_NAME;
	private final String NAME;
	
	public Component(String name, String serverAddress, int port){
		this.HOST_PORT = port;
		this.NAME = name;
		this.HOST_NAME = serverAddress;
	}
	
	public void startServer() {
		Server server = new Server(this.HOST_PORT);
		System.out.println("Starting server for Component "+this.NAME+" on Thread (id: "+server.getId()+")");
		server.start();
	}
	
	public void sendMessageTo(Component destination, String message) {
		new Client(destination.getHostName(), destination.getPort(), message).start();
	}
	
	private int getPort() {
		return this.HOST_PORT;
	}
	
	private String getHostName() {
		return this.HOST_NAME;
	}
	
}