package _09_backup;

import java.io.FileNotFoundException;

public class TestArr {
	public static void main(String[] args) {
		int j[] = {1, 2, 3};
		System.out.println(j.length);
		
		int i[];
		i = new int[5];
		System.out.println(i.length);
		
		int i1[]= new int[5];
		System.out.println(i1.length);
		
		String s[] = {"a","b","c"};
		System.out.println(s.length);
/*		
		Date x[];
		x = new Date[3];
		for(int n = 0; n < x.length; n++) {
			x[n] = new Date(2000, 8 ,n+1);
		}*/
		
/*		Date date[];
		date = new Date[2];
		date[0] = new Date(1,2,3);
		date[1] = new Date(4,5,6);*/
		
		Date date[] = {				new Date(1,2,3),				new Date(4,5,6)		};
		
/*		try{
		System.out.println(arr[0]+" ; "+arr[2]/0);
		}catch (ArithmeticException ex) {
			System.out.println("除数不能为0。");
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			
		}*/
//		String s[] = {"a", "a", "c", "d"};
//		System.out.println(s[1]+" ; "+s[3]);
//		System.out.println(s[0].equals(s[2]));
	}
	
	class Date{
//		Date date = new Date;
		int year, month, day;
		Date(int _year, int _month, int _day){
			year = _year;
			month = _month;
			day = _day;
		}
	}
	
/*	void method() throws IOException,OutOfMemoryError{
		
	}*/

}

/*try {
}catch(someException e) {
	e.somtMethod();
}catch(someException e) {
	printStackTrace();
	printStack
}finally()
FileNotFoundException
IOException
*/