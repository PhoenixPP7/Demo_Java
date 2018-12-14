package _00_Java;

public class Java {
}

/*
=====系统常用包
	java.lang=包含了Object、String、Integer等类;
	java.lang.reflect=反射开发包;
	java.util=Java的工具包,提供了大量的工具类,如链表;
	java.util.regex=正则工具包;
	java.text=国际化处理程序包;
	java.io=进行输入、输出处理以及文件操作;
	jiava.net=进行网络编程开发包;
	java.sql=数据库程序开发包;
	java.applet=Applet程序开发包(不再使用);(如再使用,使用Canvas绘图---HTML5)
	java.awt、javax.swing=图形界面开发包;
	javax.*=Java扩展包;

=====访问控制权限
=====说明=1.Java的封装性是利用private、default、protect三种权限定义的;	2.大部分情况下,声明属性使用=private,声明方法使用=public;
	private(常用)=同一个类中;
	default=同一个类中;同一个包中不同类;
	protect=同一个类中;同一个包中不同类;不同包的子类;
	public(常用)=同一个类中;同一个包中不同类;不同包的子类;不同包的非子类;

=====命名规范
	类名称=每一个单词的首字母大写,其余字母小写;例="StudentInfo";
	接口名称=但使用"interface"关键字,名称前增加"I",其他与类名称相同;例="public interface IEmpService";
	属性名称=第一个单词字母小写,之后每个单词首字母大写;例="studentName";
	方法名称=第一个单词字母小写,之后每个单词首字母大写;例="getName()";
	常量名称=所有字母都是用大写;例="MSG";
	包名称=所有字母都是用小写;例="cn.mldn.demo";
	
==========数据类型转换总结
=====日期转换
	[Date]与String转换依靠[SimpleDateFormat];
	long和[Date]转换依靠[Date]类提供的构造方法和[getTime()]方法;
=====String和基本类型(int、double、long、float、boolean、char...)转换
	基本类型转换为String类型=使用[String]类的[valueOf()]方法;例="String.valueOf(int i)";
	String类型转换为字节数组=使用[String]类的[getBytes()]方法;例="str.getBytes()";
=====Oracle数据库数据类型对应Java数据类型
		VARCHAR2=String;
		CLOB=String;
		Number=double、int;
		Date=java.util.Date;
*/

/*
=====对象类型的向下转型和向上转型
	向上转型=核心目的是统一操作的参数;
	向下转型=核心目的是操作子类定义的特殊功能,(不安全);

=====[Object]类中常被覆写的方法=
	toString();直接输出对象的时候,其实默认调用了Object类的toString()方法,输出为对象的编码;
	对象比较=[public boolean equals(Object obj)];通过此方法将对象的属性进行依次比较是否都相同;应比较实现类对象中所有属性内容,需在各个类中自己定义覆写equals()方法,注意判断是否为null、地址是否相同、属性是否相同、是否需要向下转型;
	取得哈希码=[public int hashCode()];通过此方法判断对象的哈希码是否相同;

=====static关键字
	说明=可以将属性或方法声明为静态的,就不需要实例化此类的对象就可以直接通过"类.属性"或"类.方法"调用了;

=====final关键字
	final多用于定义全局常量,全局常量每个字母均需大写;例=private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	final定义的类或方法不能被继承或重写;

=====包装类(基本数据类型的包装类)
	基本数据类型及包装类=byte(Byte)、short(Short)、int(Integer)、long(Long)、float(Float)、double(Double)、char(Character)、boolean(Boolean);
=====包装类-自动装箱与自动拆箱
	自动装箱,例=[Integer obj = 100];
	自动拆箱,例=[int temp = obj];
=====包装类-"String"类型转换基本数据类型;
	例=[Sting str = "100" ; int temp = Integer.parseInt(str);];---常用的Integer、Double、Boolean类似;
=====包装类-基本数据类型转换为"String"类型;
	例=[int num = 100 ; String str = String.valueOf(num);];
=====包装类-手动装箱与手动拆箱
	手动装箱,例=[Integer obj = new Integer(100)];
	手动拆箱,例=[int temp = obj.intValue()];
	
==========多态性
=====对象的多态性=指的是发生在继承关系类中,子类和父类之间的转换关系;
		向上转型(自动完成)		=父类 父类对象 = new 子类实例;			---好处=同一个"父类对象"(统一了同一个"父类对象"这个参数)可以根据不同的"子类实例"调用被不同子类覆写的方法;"父类对象"只能调用"父类"中定义的方法;
		向下转型(强制完成,不安全)	=子类 子类对象 = (子类) 父类实例;		---需先向上转型,才能向下转型,否则会错"ClassCaseException";向上转型之后,若还需要再调用子类独有的方法时,需要将"父类对象"向下转型为"子类对象"之后再调用子类独有的方法;
	总结=
		80%的情况使用向上转型,可以取得参数类型的统一(都是同一个"父类对象"),方便程序设计;使用子类都会统一向上转型使用它们的父类或接口;
		15%的情况不转型;
		5%的情况使用向下转型,目的是调用子类的独有方法;不安全,需先向上转型,才能向下转型,否则会错"ClassCaseException";
=====方法的多态性=
		方法的重载=同一个方法名称,根据传入的参数类型及个数不同执行不同的方法体;
		方法的覆写=同一个方法,会根据子类的不同没实现不同的功能;
*/

/*
=====普通类-组成=
	可以包含=构造方法、普通方法、static方法、常量、变量等;
=====普通类-使用原则=
	虽然子类可以继承普通类,但从开发实际要求出发,普通类不要继承普通类,应继承抽象类,实现接口类;

=====接口-组成=
	关键字=使用"interface"关键字,名称前增加"I",例=[public interface IDAO<K,V>];
	抽象方法,例=[public abstract boolean doCreate()]; (抽象方法没有方法体,不需要"{}";"abstract"一般省略书写;权限只能是public,即使省略不写也不是default,而是public)
	全局常量,例=[public static final String MASSAGE="Hello"];(大部分情况下不用全局常量;只能是全局常量,即使省略不写"public static final",也是全局常量)
=====接口-使用原则=
	必须有子类,子类使用"implements"关键字;子类(接口实现类)-命名规则=类名称后面增加"Impl",例="SonClassImpl implements IMyClass";
	子类必须覆写接口中的全部抽象方法;
	可以有多个子类"implements"同一个接口;
	接口的对象可以使用子类的对象香山转型进行实例化操作;例=Father f = new Son();
	接口可以使用关键字"extends"继承多个接口;
	不要直接使用关键字new实例化接口子类,而是使用工厂类;
=====接口-总结=
	定义不同层之间的操作标准;
	表示一种操作的能力;
	表示将服务器端的远程方法视图暴露给客户端;
	先继承后实现接口,例=[public class EmpDAOImpl extends AbstractDAOImpl implements IEmpDAO]

=====抽象类-组成=
	关键字=使用"abstract"关键字,例=[public abstract class AbstractDAOImpl];
	在普通类的基础上增加了抽象方法;抽象方法没有方法体"{}";例=[public abstract void print()];
	抽象方法=
	普通方法;
=====抽象类-使用原则=
	必须有子类;
	子类必须覆写抽象类之中的全部抽象方法;
	子类完成抽象类的对象实例化,采用向上转型的方式;
	抽象类一定存在构造方法,用于为属性初始化;子类实例化时会先执行父类构造,再调用子类构造;
	抽象类不能被实例化;因为抽象方法没有方法体,无法被调用,故无法产生实例化对象,不符合逻辑;
=====抽象类-总结=	
	抽象类强制规定了子类必须要做的事,可以用抽象类的普通方法实现;
*/

/*
==========工厂、代理、单例是Java三大核心设计模式;
例=数据库更新中的事务处理操作,DAO接口类中doXxxx开头的都是更新操作,更新操作必须有事务处理操作,属于真实主题类;查询操作不需要事务处理,辅助功能,属于代理主题类;

=====工厂设计模式(Factory)=详见=[DemoFactory.java];---接口的应用
	解决的问题=客户端调用简单,不需要关注具体细节;减低耦合度,方便维护;

=====代理设计模式(Proxy)=详见=[DemoProxy.java];---接口的应用
	代理模式=分为核心主题和代理主题,核心主题只完成核心业务功能,代理主题完成所有与核心主题相关的辅助性操作;

=====单例设计模式(Singleton)=详见=[DemoSingleton.java];
	说明=一个类只能产生唯一的一个实例化对象;
	实现方式=类中构造方法的私有化(private),使用static及final关键字定义一个公共且唯一的对象,这样不管类外部怎么调用,都只能产生唯一的一个对象;
	
=====多例设计模式
	说明=相对于单例设计模式只能让一个类产生一个实例化对象,多例设计模式可以让一个类产生指定多个实例化对象;
	例=定义一个表示性别的类,则该类只能产生两个实例化对象;
	
=====枚举(enum关键字)
	枚举属于高级的多例设计模式;可以简化的替代多例设计模式;
	enum和Enum的区别?
		enum是一个关键字,Enum是一个抽象类;使用enum定义的枚举就相当于一个类继承了Enum这个抽象类;
		
=====Annotation声明
	三个最常用的基础Annotation
		@Override=准确覆写声明;方法上增加了"@Override"后意味着告诉编译器,此方法是覆写的,如果不是覆写方法则报错;
		@SuppressWarnings=压制警告声明;取消编译器警告信息;
		@Deprecated=过期声明;可以很好地实现新旧方法的交替;
		@FunctionalInterface=函数式接口声明,只能定义一个方法;

=====Lamda表达式,函数式编程
	说明=Lamda表达式可以简化匿名内部类的编写;
	Lamda表达式有三种形式=
		1.(参数)->单行语句;
		2.(参数)->{单行语句;单行语句};
		3.(参数)->表达式;

=====方法引用
	说明=方法引用是指为一个方法设置别名,相当于一个方法定义了不同的名字;方法引用需要使用接口;
	四种形式=
		1.引用静态方法=[类名称 :: static 方法名称];
		2.引用某个对象的方法=[实例化对象 :: 普通方法];
		3.引用特定类型的方法=[特定类 :: 普通方法];
		4.引用构造方法=[类名称 :: new];
		
=====引用传递
	说明=将实例化对象当做参数传递给方法;例=StringBuff buf = new StringBuffer();	method(buf);

=====内建函数式接口
	说明=主要用于数据流[java.util.stream Interface Stream<T>];
	java.util.function包提供以下四个核心接口=
		功能型接口=[public interface Function<T,R> {public R apply(T t);}];此接口需要接收一个参数,并返回一个处理结果;
		消费型接口=[public interface Consumer<T> {public void accept(T t);}];此接口只负责接收数据,并不返回处理结果;
		供给型接口=[public interface Supplier<T> {public T get()}];此接口不接收参数,只返回结果;
		断言型接口=[public interface Predicate<T> {public boolean test(T t);}]此接口进行判断操作使用;
*/

/*
=====正则表达式
	正则表达式中"\\"代表转义开始,在字符前面加了"\\"才表示该字符;例=["\\|"表示"\"];["\\\"表示"\"]
*/

/*
==========问题

=====[B类]实现了[A接口],声明对象时使用[A obj = new B()],而不用[B obj = new B()];
	这中写法实现"动态更换";如[List list =new ArrayLIst()]改变为[List list = new LinkedList()],其中list对象就实现了更换实现类,不需要更改其他的代码。

====="length"、"length()"、"size()"的区别
	"length"=数组对象的属性,取得数组的长度;
	"length()"=[String]类的方法,取得字符串的长度;
	"size()"=集合类的方法,取得元素的个数;
	
====="=="和"equals()"的区别?
	"=="是Java提供的关系运算符,主要用于数值判断是否相等;如果用于String对象,表示内存地址数值是否相等;
	"equals()"是String类提供的一个方法,用于字符串内容比较是否相等;

=====String()和toString()区别?
	String()和toString()都会返回字符串，区别在于对null的处理,
		String()会返回字符串"null";
		toString() 就会报错，无法执行;

=====方法的重载(Overload)和覆写(Override)的区别=
	重载(Overload)=		发生范围=一个类中;	定义=方法名称、参数类型及个数不同,返回值可以不同,但建议相同;	权限=不涉及权限;
	覆写(Override)=		发生范围=继承类中;	定义=方法名称、参数类型及个数、返回值相同;						权限=子类覆写的方法访问控制权限不能小于父类的;

=====接口和抽象类的区别?
	接口=	关键字=[interface];		组成=抽象方法、全局常量;									子类使用=[implements];	关系=接口不能继承抽象类;可以继承多个父接口;	权限=只能使用public权限;	限制=没有单继承局限;	子类及实例化=必须有实现类,实现类必须覆盖全部抽象方法,依靠子类对象的向上转型进行对象的实例化;
	抽象类=	关键字=[abstract	class]; 组成=构造方法、普通方法、抽象方法、static方法、常量、变量;	子类使用=[extends]	;	关系=抽象类可以实现多个接口;					权限=可以使用各种权限;	限制=单继承局限;		子类及实例化=同上;

=====final、finally、finalize的区别?
	final=是一个关键字=用于定义不能被继承的类、不能被覆写的方法、常量;
	finally=是一个关键字=异常的统一出口;
	finalize=是一个方法=Object类提供的方法[protected void finalize() throws Throwable],垃圾回收前的收尾方法,即使出现异常也不会导致程序中断执行;

=====Java中有几个标识型接口?
	标识接口中没有任何方法,表示一种能力;
	克隆接口=[java.lang Interface Cloneable];用于对象克隆;
	序列化接口=[java.io Interface Serializabl];用于对象序列化;
	

*/

/*
=====工厂设计模式=详见=[DemoFactory.java]
=====代理设计模式=详见=[DemoProxy.java];
=====单例设计模式=详见=[DemoSingleton.java];
=====泛型=详见=[DemoGenerics.java]
=====对象引用=详见=[DemoReference.java]
=====字符串处理类=[String]、[StringBuffer]、[StringBuilder]=详见[DemoString.java];
=====异常操作类=[Exception]、[RuntimeException]=详见[DemoException.java];
=====线程操作类=[Thread]类、[Runnable]接口=详见[DemoThread.java];
=====数学操作类=[Math]、[Random]、[BigInteger]、[BigDecimal]=详见[DemoMath.java];
=====日期处理类=[Date]、[Calendar]、[SimpleDateFormat]=详见[DemoDate.java];
=====比较器=[Comparable]、[Arrays]、[Comparator]=详见[DemoComparable.java];
=====正则表达式=[String]、[Pattern]、[Matcher]=[DemoRegex.java];
=====IO操作=[File]、[OutputStream]、[InputStream]、[Writer]、[Reader]=详见[DemoIO.java];
=====类集=[Collection]、[List]、[Set]、[Map]、[Iterator]、[Stream]=详见[DemoCollectionMapIterator.java];
*/










