package _09_backup;

class Test {
	static int id = 410526;
	
	Test(){
		System.out.println("构造方法-没有传入值");
	}
	
	Test(int i) {
		id = i ;
//		System.out.println("构造方法-有传入值 : "+i);
	}
	
	void print() {
		System.out.println("id = "+id);
	}
	
	Test(int i, int j){
		
	}
	
	void method() {
		System.out.println("方法重载-没有传入值");
	}
	
	void method(int i) {
		System.out.println("方法重载-有传入值 : "+i);
	}
	
	public int getId() {
		return id;
	}
	
/*	void method(int i, int j) {
		return i > j ? i : j;
		
	}*/
	
	void method(char c) {
		System.out.println("a char");
	}
	
	void method(String s) {
		System.out.println(s+" ; id = "+id);
	}
}

public class TestOverload {

	public static void main(String[] args) {
		Test t1 = new Test(110106);
		System.out.println(t1.id);
		t1.print();
/*		Test t2 = new Test(5);
		Test t3 = new Test(25,30);
		t1.method();
		t1.method(15,20);
		t2.method(10);
		t3.method(15,20);
		t1.method("LZP");
		t1.getId();
		t3.method('a');*/

	}

}
