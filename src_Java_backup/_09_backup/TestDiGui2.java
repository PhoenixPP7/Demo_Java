package _09_backup;

public class TestDiGui2 {

	public static void main(String[] args) {
		System.out.println(method1(10));
	}
	
	public static int method1(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}else {
			return method1(n-1)+method1(n-2);
		}
	}

}
