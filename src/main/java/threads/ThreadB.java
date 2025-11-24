package threads;

public class ThreadB extends Thread {
	
	Counter c;
	
	public ThreadB(Counter c) {
		this.c=c;
	}
	
	@Override
	public void run() {
		for(int i=0;i<200;i++) {
			c.increment();
			System.out.println("ThreadB invoked");
		}
	}
}
