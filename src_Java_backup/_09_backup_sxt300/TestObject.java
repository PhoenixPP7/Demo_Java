package _09_backup_sxt300;
public class TestObject {
	public static void main(String[] args) {
//		Object obj;		
		TestObject   to = new TestObject();
		System.out.println(to);
		Person2  p2 = new Person2("ϣϣ", 6);
		System.out.println(p2.toString()); 
		
	}
	
    public String toString() {
    	return "������TestObject������д��toString����!";
    }

}

class Person2 {
    String name;
    int age;
    
    @Override
    public String toString() {
    	return "name = " + name + ";\nage = " + age;
    }
    
    public Person2(String  name, int age) {
    	this.name = name;
    	this.age = age;
	}
    
}
