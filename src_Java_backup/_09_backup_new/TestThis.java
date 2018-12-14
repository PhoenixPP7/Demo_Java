package _09_backup_new;
class Person{
	int age;
	String name;
	public Person(){
		
	}
	public Person(int age){
		this.age=age;
		System.out.println("Person(int age)");
	}
	public Person(int age,String name){
		this(age);
		this.name=name;
	}
	public Person(String name,int age){
		this.age = age;
		this.name=name;
	}
}
	

public class TestThis {

	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1.age + " = " + p1.name);
		Person p2 = new Person(10);
		System.out.println(p2.age + " = " + p2.name);
		Person p3 = new Person(10,"pp");
		System.out.println(p3.age + " = " + p3.name);
		Person p4 = new Person("dd",22);
		System.out.println(p4.age + " = " + p4.name);
	}

}
