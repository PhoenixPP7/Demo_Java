package _09_backup_new;

public class TestRunable {

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		new Thread(mr,"�̶߳���1").start();
		new Thread(mr,"�̶߳���2").start();
		new Thread(mr,"�̶߳���3").start();

	}

}

class MyRunnable implements Runnable{
//	String name;
//	MyRunnable(String name){
//		this.name = name;
//	}

	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " --> i = " + i);
		}
	}
	
}
