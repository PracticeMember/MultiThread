package threads;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Counter c=new Counter();
		
//		Thread t1=Thread.ofVirtual().start(()->{
//			for(int i=0;i<200;i++) {
//				c.increment();
//				System.out.println("ThreadA invoked");
//			}
//		});
//		Thread t2=Thread.ofVirtual().start(()->{
//			for(int i=0;i<200;i++) {
//				c.increment();
//				System.out.println("ThreadB invoked");
//			}
//		});
		
		Thread t1=new ThreadA(c);
		Thread t2=new ThreadB(c);
		long s=System.currentTimeMillis();
		System.out.println(s);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long e=System.currentTimeMillis();
		System.out.println(e);
		System.out.println(e-s);
	}

}
