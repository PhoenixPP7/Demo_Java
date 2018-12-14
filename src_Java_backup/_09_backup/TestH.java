package _09_backup;

public class TestH{

	public static void main(String[] args) {
	
		Students s = new Students("pp1", 23, "CS");
		
		System.out.println("name = " + s.name + ";\tage = " + s.age +"\tmajor = " + s.major);
		
		System.out.println(s instanceof Persons);
		System.out.println(s instanceof Students);
		System.out.println(s instanceof Object);
		System.out.println(new Students() instanceof Object);

	}


}

class Persons{
	String name;
	int age;
	void sleep() {
		System.out.println("sleep for 8h!");
	}
}

class Students extends Persons{
	String major;
	public Students(String name, int age, String major){
		this.name = name;
		this.age = age;
		this.major = major;
	}
	public Students() {
	}
}