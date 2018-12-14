package _09_backup;

public class TestToString {
	public static void main(String[] args) {
		Dog2 d = new Dog2();
		System.out.println("d = "+d);
	}
}

class Dog2{
	public String toString(){
		return "Dog is here!";
	}
	
}