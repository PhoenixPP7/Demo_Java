package _00_Java;
interface IFruit {
	public void eat();
}

class Apple implements IFruit {
	public void eat() {
		System.out.println("执行Apple类!");
	}
}

class Orange implements IFruit {
	public void eat() {
		System.out.println("执行Orange类!");
	}
}

class Factory {
	public static IFruit getInstance(String className) {
		if ("apple".equals(className)){
			return new Apple();
		} else if ("orange".equals(className)) {
			return new Orange();
		} else {
			return null;
		}
	}
}

public class DemoFactory {
	public static void main(String[] args) {
		IFruit f = Factory.getInstance("apple");
		f.eat();
	}

}
