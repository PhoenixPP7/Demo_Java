package _09_backup;



public class TestStatic {
	static int sid = 0;
	String name;
	int id;
	
	TestStatic(String name){
		this.name = name;
		id = sid++;
	}
	
	void info(){
		System.out.println("Cat's name :"+name+"Cat's id ="+id);
	}
	
	static void infor() {
		System.out.println(sid);
	}	
	
	static void infor2() {
		System.out.println(sid);
	}
	
	public static void main(String[] args) {
		TestStatic.sid = 100;
		TestStatic mimi = new TestStatic("mimi");
		TestStatic maomi = new TestStatic("maomi");
		mimi.info();
		mimi.sid = 2000;
		maomi.info();
		infor();
		infor2();
	}

}
