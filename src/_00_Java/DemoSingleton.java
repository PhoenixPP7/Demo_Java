package _00_Java;
class Singleton {
	private static final Singleton INSTANCE = new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		return INSTANCE;
	}
	public void print() {
		System.out.println("Printing Singleton!");
	}
}

public class DemoSingleton {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.print();
	}
}
