package _09_backup_new;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestThread {

	public static void main(String[] args) throws Exception {
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		FutureTask<String> task1 = new FutureTask<String>(mt1);
		FutureTask<String> task2 = new FutureTask<String>(mt2);
		new Thread(task1).start();
		new Thread(task2).start();
		System.out.println("mt1 --> " + task1.get());
		System.out.println("mt1 --> " + task2.get());
	}

}

class MyThread implements Callable<String> {
//	String name;
//	
//	public MyThread(String name) {
//		this.name = name;
//	}
//
//	public void run() {
//		for(int i = 0 ; i < 100 ; i++) {
//			System.out.println(this.name + " ---> " + i);
//		}
//	}

	private int ticket = 10;
	@Override
	public String call() throws Exception {
		for(int i = 0 ; i < 100 ; i++) {
			if (this.ticket >0) {
				System.out.println( "Ticket = " + this.ticket--);				
			}
		}
		return "Ticket is null !";
	}
}