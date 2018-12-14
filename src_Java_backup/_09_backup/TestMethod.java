package _09_backup;

public class TestMethod {

	public static void main(String[] args) {
		method1();
		System.out.println();
		method2(6);
//		method3(3,4);
		int i = method3('1', 10);
		System.out.println(i);
	}
	
	public static int method1() {
		System.out.println("void;");
		return 2;
	}
	
	public static void method2(int i) {
		if(i < 5)
			System.out.println("i > 2");
		else
			//return;
			System.out.println("i > 5");
	}
	
	public static int method3(int i, int j) {
/*		int n;
		n = i * j;
		System.out.println("n = "+n);*/
		System.out.println("method3");
		return i > j ? i : j;
	}

}
