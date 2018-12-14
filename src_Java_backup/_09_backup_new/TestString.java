package _09_backup_new;

public class TestString {

	public static void main(String[] args) {
		String c = new String("abc").intern();
		String a = "abc";
		String b = "abc";
		
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a == c);

	}

}
