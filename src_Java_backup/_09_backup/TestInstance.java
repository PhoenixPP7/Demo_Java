package _09_backup;

public class TestInstance {
	public static void main(String[] args) {
		Animal a = new Animal("Animal name");
		Cat maoMi = new Cat("maoMi", "blue");
		Doggy daHuang = new Doggy("daHuang", "yellow");
		TestInstance testInstance = new TestInstance();
//		testInstance.instance(a);
//		testInstance.instance(maoMi);
		testInstance.instance(daHuang);
		}
	
	void instance(Animal a) {
		if (a instanceof Animal) {
		System.out.println("Animal name : "+a.name);
		}else if(a instanceof Cat) {
			Cat cat =(Cat)a;
			System.out.println("Cat name : "+cat.name+"; Cat eyeColor : "+cat.eyeColor);
			}else if(a instanceof Doggy) {
				Doggy doggy = (Doggy)a;
				System.out.println("Doggy name : "+doggy.name+"; Doggy eyeColor : "+doggy.furColor);
				}
		}
	
}

class Animal{
	String name;
	Animal(String name){
		this.name = name;
	}
}

class Cat extends Animal {
	String eyeColor;
	Cat(String name,String _eyeColor){
		super(name);
		eyeColor = _eyeColor;
	}
}

class Doggy extends Animal{
	String furColor;
	Doggy(String name,String _furColor){
		super(name);
		furColor = _furColor;		
	}
}

