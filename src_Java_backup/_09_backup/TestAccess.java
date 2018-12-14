package _09_backup;
class T{
	private int i = 1;
	int j = 2;
	protected int k = 3;
	public int m = 4;
	void m() {
		T t = new T();
		System.out.println(t.i);
		System.out.println(t.j);
		System.out.println(t.k);
		System.out.println(t.m);
	}
}

class TT{
	void m() {
		T t = new T();
//		System.out.println(t.i);
		System.out.println(t.j);
		System.out.println(t.k);
		System.out.println(t.m);
	}
}

public class TestAccess {

	public static void main(String[] args) {


	}

}
