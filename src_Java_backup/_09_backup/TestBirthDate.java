package _09_backup;

public class TestBirthDate {
	static int day;
	int month;
	int year;
	
	TestBirthDate(int d, int m, int y){
		day = d;
		month = m;
		year = y;				
	}
	
	static void setDay(int d) {
		day = d;
	}
	
	static int getDay() {
		return day;
	}
	
	public void change(TestBirthDate t0) {
		t0 =new TestBirthDate(6,6,6);
	}

	public static void main(String[] args) {
		TestBirthDate t1 = new TestBirthDate(2,3,4);
		t1.change(t1);
		System.out.println(t1.day);
		setDay(5);
		getDay();
		System.out.println(t1.day);
	}

}
