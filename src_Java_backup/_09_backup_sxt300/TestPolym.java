package _09_backup_sxt300;

/**
 * ���Զ�̬
 * @author ���
 *
 */
public class TestPolym {
	public static void main(String[] args) {
		TestPolym t = new TestPolym();
		Animal d = new Dog();//�Զ�����ת��
		Animal c = new Cat();
		t.animalCry(d);
		d.shout();
		
		Dog dd = (Dog)d;//ǿ������ת��
//		Dog ddd = (Dog)c;//ǿ������ת��//����,����ת��
		dd.seeDoor();
//		ddd.seeDoor();
		
		t.animalCry(c);
		
		t.animalCry(new Dog());
		
//		Animal   a = new Animal();
//		t.animalCry(a); 
//		
//		Animal  d = new Dog();			//�Զ�����ת��
//		t.animalCry(d);
//		Animal   c = new Cat();
//		t.animalCry(new Cat());
//		
//		Dog  d2 = (Dog) d;			//ǿ������ת��
//		d2.seeDoor();
//		Dog   d3 = (Dog) c;
//		d3.seeDoor();
		
		//java300�������и���ϸ�Ľ��⡣
		
	}
	
	void  animalCry(Animal  a){
		a.shout();
	}
	
	/*static  void  animalCry(Dog  a){
		a.shout();
	}
	static  void  animalCry(Cat  a){
		a.shout();
	}*/
	
}

  class  Animal {
	
    public    void shout() {
        System.out.println("Animal����һ����");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("Dog��������");
    }
    
    public  void   seeDoor(){
    	System.out.println("Dog���ţ�����");   
    }
    
}
class Cat extends Animal {
    public void shout() {
        System.out.println("Cat����������");
    }
}

