package _09_backup;

public class TestDiGui {

	public static void main(String[] args) {
		System.out.println(method1(5));
	}
	
	public static int method1(int i) {
		if(i == 1) {
			return i;
		}else {
			return i*method1(i-1);
		}
		
	}

}
