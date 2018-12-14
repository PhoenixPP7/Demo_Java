package _00_Java;

interface Subject {
	public void make();
}

class RealSubject implements Subject {
	public void make() {
		System.out.println("RealSubject 正在执行核心业务主题!");
	}
}

class ProxySubject implements Subject {
	private Subject subject;
	public ProxySubject(Subject subject) {
		this.subject = subject;
	}
	public void prepare() {
		System.out.println("ProxySubject 正在执行核心业务主题操作前的准备(辅助业务主题)!");
	}
	public void make() {
		this.prepare();
		this.subject.make();
		this.destory();
	}
	public void destory() {
		System.out.println("ProxySbuject 正在执行核心业务主题完成后的收尾(辅助业务主题)!");
	}
}

public class DemoProxy {
	public static void main(String[] args) {
		Subject sub = new ProxySubject(new RealSubject());
		sub.make();
	}
}
