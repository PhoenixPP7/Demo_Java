package _09_backup;
class InnerClass{
	static int i = 10;
	void outPut(){
		System.out.println(i);
	}

}

public class TestClass extends InnerClass {
	static int i = 2;

	public static void main(String[] args) {
//		InnerClass in = new InnerClass();
//		System.out.println(in.i);
		System.out.println(i);


	}

}
