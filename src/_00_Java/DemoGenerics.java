package _00_Java;
//<T>T是Type是一个标记,在调用的时候需要将T设置为具体的类型,只能传引用类型,不能是基本数据类型;
class Generics<T> {
	private T msg;
	public void setMsg(T msg){
		this.msg = msg;
	}
	public T getMsg(){
		return msg;
	}
}
public class DemoGenerics {
	public static void main(String[] args) {
		//步骤一=(建议)设置泛型具体类型<Integer>、<String>...;(不建议)g2没有设置具体类型,则g2是Object类型;
		//JDK 1.7之后实例化声明类型可以省略,例="new GenericsTest1<>();
		Generics<Integer> g = new Generics<Integer>();
		//设置数据;利用包装类的自动装箱功能;
		g.setMsg(99);
		//步骤二=(建议)取出数据,g1不再需要向下强制转型;(不建议)g2需要强制转型;
		int x = g.getMsg();
		System.out.println("x = " + x);
	}
	
	/*
	public static void main(String[] args) {
		Message<Integer> m1 = new Message<Integer>();
		m1.setMsg(100);
		fun(m1);
	}
	public static void fun(Message<?> temp){
		System.out.println(temp.getMsg());
	}
	*/
	
}
/*
//设置一个泛型接口;
interface IMessage <T> {
	public void print(T t);	
}
方式1=子类同样设置泛型;
class MessageImpl<T> implements IMessage<T>{
	public void print(T t) {
		System.out.println(t);		
	}
}
//方式2=子类明确设置泛型类型;
class MessageImpl implements IMessage<String>{
	public void print(String t) {
		System.out.println(t);
	}
}
public class DemoGenerics {
	public static void main(String[] args) {
		IMessage<String> m = new MessageImpl();
		T.print("Hi MessageImpl!");
	}
}

	泛型通配符="<?>",可以接受一个类的任意的泛型类型,但不允许修改或设置类型,只能赋值或取出,例=public static void fun(Message<?> temp)
		子通配符="<? extends>"=设置泛型上限;例="<? extends Number>",可设值Number或它的子类,如Integer、Double...;
		子通配符="<? spuer>"=设置泛型下限;例="<? super String>",可设值String 或是它的父类Object;
*/

/*
	泛型-总结=
		1.泛型可以解决向下转型带来的安全隐患,核心用处是在声明类或接口的时候不设置参数或属性的类型;
		2."?"可以接收任意的泛型类型,只能取出,不能修改;
	泛型说明=泛型声明只能使用包装类,如<String>、<Integer>、<Double>...,不能用<int>、<double>...;
	定义类时定义一个标记<T>(T=Type),T仅作为一个标记,在调用的时候需要将T设置为具体的类型;
*/