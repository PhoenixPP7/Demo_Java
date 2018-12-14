package _09_backup;

public class Test08 {

	public static void main(String[] args) {
		int i = 8;
		char c = 'a';
		int m = 7;
//		int t;
//		System.out.println(10/0);
		System.out.println("i = "+i+"; m = "+m);
		i = i + m;
		m = i - m;
		i = i - m;

/*		t = i;
		i = m ;
		m = t;*/
		System.out.println("i = "+i+"; m = "+m);
/*		i += i;
		System.out.println("i ="+(i--));
		System.out.println("i ="+i);
		String s = "na";
		s += s;
		s = s +"me";
		System.out.println("s ="+s);*/

	}

}
