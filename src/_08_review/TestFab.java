package _08_review;

public class TestFab {

	public static void main(String[] args) {
		System.out.println(fab(-9));
	}

	public static int fab(int index) {
		if(index < 1) {
			System.out.println("Invalid Parameter!");
			System.out.println("Please in put a number between 1 and 10000");
			return -1;
		}
		
		if(index == 1 || index == 2)
			return 1;
		
		int n1 =1, n2 = 1, n3 = 0;
		for(int i = 1; i <= index; i++ ) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}
}
