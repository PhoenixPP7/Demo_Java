package _09_backup;

class Person{
	String name;
	int age;
	
	void setName(String name){
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	void setAge(int age) {
		this.age = age;
	}
	
	int getAge() {
		return age;
	}
	
	String getInfo() {
		return "Name : "+name+"; age = "+age;
	}
	
}

class Student extends Person{
	String school;
	
	void setSchool(String school){
		this.school = school;
	}
	String getInfo() {
//		System.out.println("Name : "+getName()+"; age = "+getAge()+";School = "+school);
		return "Name : "+getName()+"; age = "+getAge()+";School = "+school;
	}
	
}

public class TestExtends extends Person {
//	Person.setAge(22);
//	setName("pppp");

	
	public static void main(String[] args) {
//		Person p = new Person();
		Student s = new Student();

		s.setName("PP");
		s.setAge(20);
		s.setSchool("LZDX");
		
		s.getInfo();
		
//		System.out.println(s.getName()+"  ; "+s.getAge()/*+" ; "+s.getSchool()*/);

	}

}
