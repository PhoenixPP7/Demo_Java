package _09_backup_new;
class Book {
	 String title ;
	 int price ;
}

public class TestClass {
	public static void main(String args []){
		Book A = new Book();
		A.title = "Java";
		A.price = 11;
		Book B = new Book();
		B.title = "Java";
		B.price = 11;
		//A = B;
		System.out.println(A.title + "---" + A.price);
		System.out.println(B.title + "---" + B.price);
		System.out.println(B);
		System.out.println(A);
		System.out.println(A == B);
		System.out.println(A.equals(B));
		System.out.println(A.title == B.title);
		System.out.println(A.price == B.price);
		System.out.println(A.title.equals(B.title));
	}
}
