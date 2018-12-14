package _09_backup;

abstract class AbstractDemo {
	void methodNormal(){}
	abstract void method();
/*
先说明一个概念=普通类中的普通方法用{}表示方法体;抽象方法没有方法体;含有抽象方法的类是抽象类,使用abstract声明,例=
	abstract class AbstractDemo{
		abstract void method();
	}
	抽象类使用原则=
		1.抽象类必须有子类,即抽象类必须被子类继承;
		2.抽象类的子类必须覆写抽象类之中的所有抽象方法,即强制子类覆写;
		3.抽象类的对象实例化需要靠子类完成,必须采用向上转型的方式处理,即=父类引用指向子类对象;
		4.实际使用中,继承一般是指普通类继承抽象类;
		5.抽象类不能用final声明,因为final声明的类不能被继承,即不能有子类;
		
	其他记录=
		switch只支持数值判断,if支持条件判断;
 */
}

class AbstractSon extends AbstractDemo{//子类继承抽象类;
	public void method(){//覆写父类抽象方法;
		System.out.println("AbstractSon!");
	}
}

public abstract class AbstractTest{
	public static void main(String args []) {
		//AbstractDemo ad = new AbstractDemo();
		//ad.method();
		AbstractDemo ad = new AbstractSon();//向上转型
		ad.method();
	}
}