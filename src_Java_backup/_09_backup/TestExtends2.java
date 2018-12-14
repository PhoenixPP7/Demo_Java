package _09_backup;



class AA{
	public void f() {
		System.out.println("AA");
	}
}

class A extends AA{
	super.f();
}

public class TestExtends2 extends AA {

	public static void main(String[] args) {
		TestExtends2 TE = new TestExtends2();
		super.f();
	}
}
