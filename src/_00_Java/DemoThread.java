package _00_Java;
class Info {
	private String title;
	private String content;
	private boolean flag = true;//true=可以生产,不可以取走;false=不可以生产,可以取走;
	public synchronized void set(String title,String content) {
		if (this.flag == false) {//重复进入了生产方法;false表示已生产,不可以再生产,所以此操作需要等待;
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
/*		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		this.content = content;
		this.flag = false;//修改标记,false表示已生产,可以取走;
		super.notify();//唤醒其他等待线程;
	}
	public synchronized void get(){
		if (this.flag == true) {//表示还未生产,可以生产;
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
/*		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println(this.title + " = " + this.content);
		this.flag = true;//修改标记,true表示已取走,可以生产;
		super.notify();//唤醒其他等待线程;
	}
}

class Productor implements Runnable {
	private Info info;
	public Productor(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for (int x = 0 ; x < 100 ; x ++) {
			if (x % 2 == 0) {//偶数
				this.info.set("(生产=偶数)" , "(购买=偶数)");
			} else {//奇数
				this.info.set("(生产=AAA)" , "(购买=AAA)");
			}
		}
	}
}

class Customer implements Runnable {
	private Info info;
	public Customer(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for (int x = 0 ; x < 100 ; x ++) {
			this.info.get();
		}
	}
}

public class DemoThread {
	public static void main(String[] args) {
		Info info = new Info();
		new Thread(new Productor(info)).start();
		new Thread(new Customer(info)).start();
	}
}

/*
=====线程
	说明-线程与进程=一个进程可以有多个线程,一个线程可以有多个子线程;线程依赖进程存在;
=====[Thread]类=java.lang.Thread
=====[Thread]类-方法
	run()方法-说明=普通类的起点是main()方法,Thread类的起点是run()方法;使用线程必须覆写run()方法;run()方法指执行一个线程;
	start()方法-说明=使用多线程须使用[Thread]类中的start()方法;start()方法会开始执行所有线程,各个线程的run()方法交替执行,抢占服务器资源;另=start()方法实现不同操作系统运行平台的统一运行;
	构造方法=[public Thread(Runnable target,String name)];参数"Runnable target"是[Runnable]接口线程对象,参数"String name"是设置线程的名字;
	设置名字=[public final void setName(String name)];
	取得名字=[public final String getName()];
	取得当前线程对象=[public static Thread currentThread()];此方法是static的,可以直接由Thread调用,不需要实例化;main()方法也是一个进程,调用此方法会输出main;
	线程休眠=[public static void sleep(long millis) throws InterruptedException];sleep()方法参数单位=毫秒;
	设置优先级=[public final void setPriority(int newPriority)];最高优先级=MAX_PRIORITY(int=10);普通优先级=NORM_PRIORITY(int=5,main方法是普通优先级);最小优先级=MIN_PRIORITY(int=1);
	取得优先级=[public final int getPriority()];
=====线程同步与死锁
	说明-同步=同步操作相较于异步操作,属于安全线程操作;多个线程访问同一资源时需处理好同步问题,可使用以下方法;注意过多的同步有可能造成死锁;
	说明-死锁=死锁是程序逻辑上的错误造成的问题;
	同步关键字=synchronized;定义在方法前面或代码块前面;
	同步方法=[public synchronized void fun(){}]
=====[Runnable]接口=java.lang.Runnable接口
=====[Runnable]接口-方法
	run()方法-使用线程必须覆写run()方法;
	[Runnable]接口多线程的启动须使用[Thread]类中的构造方法=[public Thread(Runnable target)],例=new Thread(run).start(); 
=====[Callable]接口=java.util.concurrent.Callable接口
	使用较麻烦=需先定义线程实现[Callable]接口,使用[FutureTask<T>]类接收[Callable]接口的返回结果,再使用[Thread]类的构造方法接收[FutureTask<T>]类的对象启动多线程;

=====补充=多线程两种实现方式"[Thread]类"和"[Runnable]接口"的区别?
	[Thread]类=单继承局限;[Thread]类是[Runnable]接口的子类;
	[Runnable]接口=建议使用[Runnable]接口;没有单继承局限;[Runnable]接口能更清楚的描述数据共享的概念;
=====补充=JVM启动的时候回启动几个线程?
	main线程=负责程序的执行及启动子线程;
	gc线程=负责垃圾回收;
*/