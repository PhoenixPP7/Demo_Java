package _09_backup;

public class TestOOP {
	Computer myComputer;

	public static void main(String[] args) {
		Computer m = new Computer();
		m.brand = "Acer";
		
		
		TestOOP t = new TestOOP();
		t.myComputer = m;
		
		t.display();
		

	}

	void display() {
		System.out.println("My compluter is :" + myComputer.brand);
	}

}

class Computer{
	String brand;
}