package threads;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {
	Semaphore s1=new Semaphore(2);
	Semaphore s2=new Semaphore(1);
	
	new Thread(()->{
		for(int i=0;i<5;i++) {
			try {
				s1.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("A");
			s2.release();
		}
	}).start();
	
	
	new Thread(()->{
		for(int i=0;i<5;i++) {
			try {
				s2.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("B");
			s1.release();
		}
	}).start();
	
	}

}
