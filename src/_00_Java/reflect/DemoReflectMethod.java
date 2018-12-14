package _00_Java.reflect;

import java.lang.reflect.Method;

public class DemoReflectMethod {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("_00_Java.reflect.Dept");	//加载Dept类;
		Object obj = cls.newInstance();							//相当于使用new关键字调用了Dept类的无参构造实例化;必须有对象才可以进行后续操作;
		Method metA = cls.getMethod("setDname", String.class);	//取得setDname()方法;
		Method metB = cls.getMethod("getDname");				//取得getDname()方法;
		metA.invoke(obj, "测试部");								//执行setDname()方法;等价于=dept类对象.setDname("测试部")方法;
		System.out.println(metB.invoke(obj));					//执行getDname()方法;
	}
}