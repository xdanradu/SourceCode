public class ThreadHelper {

	public static void monitorRunningThreads() {
		
		int numberOfRunningThreads = 0;
		System.out.println("RUNNING Threads");
		for (Thread t : Thread.getAllStackTraces().keySet()) {
			if (t.getState() == Thread.State.RUNNABLE) {
				numberOfRunningThreads++;
				System.out.println("Id: " + t.getId() + " " +t.getClass());
			}
		}
		System.out.println("Number of running threads: " + numberOfRunningThreads);
	}
	
	public static void monitorThreadsAfter(int delayInMillis) {
		try {
		    Thread.sleep(delayInMillis);
		    monitorRunningThreads();
		} catch(InterruptedException ex) {
		    System.out.println(ex.getMessage());
		}
	}

}