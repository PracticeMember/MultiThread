package threads;

public class ThreadA extends Thread{

	Counter c;
	
	public ThreadA(Counter c) {
		this.c=c;
	}
	
	@Override
	public void run() {
		for(int i=0;i<200;i++) {
			c.increment();
			System.out.println("ThreadA invoked");
		}
	}
}
