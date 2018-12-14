package _00_Java.reflect;

import java.lang.annotation.Annotation;


public class DemoReflect {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> cls = Class.forName("_00_Java.reflect.Dept");	//加载Dept类;
		Annotation an[] = cls.getAnnotations();
		for ( int x = 0 ; x < an.length ; x ++){
			//System.out.println(an[x]);
			DemoAnnotation da = (DemoAnnotation) an[x];	//Annotation向下强制转型为DemoAnnotation
			System.out.println(da.name() + " , " + da.value());
		}
		
		Class<?> clsA = DemoReflect.class;//取得当前类的Class类对象;
		System.out.println(clsA.getClassLoader());//输出系统加载器=sun.misc.Launcher$AppClassLoader@73d16e93;
		System.out.println(clsA.getClassLoader().getParent());//输出扩展加载器=sun.misc.Launcher$ExtClassLoader@74a14482;
	}
}

/*
==========反射
=====说明
	正常Java程序流程=先有类,再产生对象;所谓反射的"反"就是指=利用对象找到对象的出处;
	通过反射机制可以取得类的实例化对象(从优秀的软件框架角度出发,在代码的编写过程中,应尽量少的出现"new"关键字,减少类型耦合的发生);然后可以使用类的实例化进行方法、成员、构造方法的操作;
	反射中,[java.lang.Class<T>]类是进行反射操作的源头,即=所有的反射都要从此类开始进行;
		"类"通过[java.lang.Class<T>]类描述;
		"构造方法"通过[java.lang.reflect.Constructor<T>]描述;
		"方法"通过[java.lang.reflect.Method]描述;
		"成员"通过[java.lang.reflect.Field]描述;

==========取得[java.lang.Class<T>]类对象=[public final class Class<T> extends Object implements Serializable, GenericDeclaration, Type, AnnotatedElement]
	说明=[Class]类是反射机制中一切操作的源头,需先取得[Class]类的实例化对象,再开始反射机制的其他操作;[Class]被final关键字修饰,不能有子类;泛型在反射的使用中非常糟糕;此类的构造方法被私有化了;
	有三种方式取得[Class]类实例化对象=
		1.(建议)使用[Class]类的[public static Class<?> forName(String className) throws ClassNotFoundException]方法;
			例=Class.forName("oracle.jdbc.driver.OracleDriver");
			说明=此方法操作前可以先不定义要操作的类;可以保持编译的正确性;
		2.使用"类.class"的形式取得反射的实例化对象;
			例=Class<?> cls = java.util.Date.class;
			此种形式只用于框架技术中;此种类型使用的前提=要操作的类必须先定义好;
		3.(不推荐)使用[java.lang.Object]类中[public final Class<?> getClass()]方法取得[java.lang.Class<T>]类的实例化对象;
			Java中所有类都是[Object]的子类,所以所有类都可以调用[getClass()]方法取得[Class]类的实例化对象;
			此方法在实际开发中很少会出现在直接的编写形式上;此种类型使用的前提=要操作的类必须先定义好;

==========利用反射机制实例化一个类对象
	方法=使用[Class]类的[public T newInstance() throws InstantiationException,IllegalAccessException]方法实现对象实例化;
	说明=该方法相当于使用new关键字调用了该类的无参构造实例化;
	例=利用反射机制实例化对象,改造工厂类,详见截图;

==========利用反射机制取得类的定义结构
	说明=[java.lang.Class<T>]类的主要功能是可以解剖一个类;[Class]类中以下方法可以取得类的包信息、名称信息、继承信息、接口信息=
		取得类所在的包=[public Package getPackage()];
		取得类的名称(建议)=只取得类名称(不含包名称)=[public String getSimpleName()];
		取得类的名称(不建议)=取得完整的类名称(包.类)=[public String getName()];
		取得类所继承的父类=[public Class<? super T> getSuperclass()];
		取得类所实现的接口=[public Class<?>[] getInterfaces()];

==========利用反射机制取得类的构造方法(了解为主)
	说明=程序设计时就要求必须有无参构造方法,所以取得某类的实例化对象用[Class]类中的[newInstance()]方法就可以完成;所以本部分内容了解即可;
		因为大部分情况下实际开发中不会使用构造方法进行参数传递,因为在进行类标准设计时都会明确要求类中提供无参构造方法,所以在这种情况下构造方法的反射调用的实际意义就不大了;方法如下=
	[java.lang.Class<T>]类中的方法=
		取得全部构造方法=[public Constructor<?>[] getConstructors() throws SecurityException];
		取得指定构造方法=[public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException,SecurityException];此方法传递的是可变参数,可为空,内容是需要匹配的参数类型;
		以上方法返回的类型都是[java.lang.reflect.Constructor<T>]类的对象;
	[java.lang.reflect.Constructor<T>]类中方法=
		实例化对象=[public T newInstance(Object... initargs) throws InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException];
			说明=此方法用法=调用指定构造方法,传递参数,进行对象实例化;
		取得构造方法的修饰符=[public int getModifiers()];
		取得构造方法的名称=[public String getName()];
		取得构造方法的参数类型=[public Class<?>[] getParameterTypes()];
		取得构造方法的参数个数=[public int getParameterCount()];
		取得构造方法上所抛出的异常类型=[public Class<?>[] getExceptionTypes()];

==========利用反射机制操作方法=
	说明=反射最大的使用情况,就是操作方法;利用反射,可以实现任意类的指定方法的调用;
	[java.lang.Class<T>]类中的方法=
		取得本类及继承的全部方法=[public Method[] getMethods() throws SecurityException];
		取得本类的方法=[public Method[] getDeclaredMethods() throws SecurityException];
		取得指定方法=[public Method getMethod(String name,Class<?>... parameterTypes) throws NoSuchMethodException,SecurityException];
		以上方法返回的类型都是[java.lang.reflect.Method]类的对象;
	[java.lang.reflect.Method]类中的方法=
		*调用指定的方法(重要)=[public Object invoke(Object obj,Object... args) throws IllegalAccessException,IllegalArgumentException,InvocationTargetException];
			说明=参数"Object obj"表示,任何方法的调用都必须有实例化对象,而后再设置参数;此方法可以直接反射调用方法;
		取得方法名字=[public String getName()];
		取得方法的参数类型=[public Class<?>[] getParameterTypes()];
		取得方法的返回值类型=[public Class<?> getReturnType()];
		
==========利用反射机制操作成员(属性)=
	说明=类中的属性一定要在本类实例化对象之后才会分配内存空间;
	[java.lang.Class<T>]类中的方法=
		取得全部继承的成员=[public Field[] getFields() throws SecurityException]
			只能取得全部非私有化成员;
		取得本类的成员=[public Field[] getDeclaredFields() throws SecurityException]
		取得继承的指定成员=[public Field getField(String name) throws NoSuchFieldException,SecurityException]
		取得本类的指定成员=[public Field getDeclaredField(String name) throws NoSuchFieldException,SecurityException]
		以上方法返回的类型都是[java.lang.reflect.Field]类的对象;
	[java.lang.reflect.Field]类中的方法=
		取得属性内容=[public Object get(Object obj) throws IllegalArgumentException,IllegalAccessException]
		取得属性类型=[public Class<?> getType()]
		设置属性内容=[public void set(Object obj,Object value) throws IllegalArgumentException,IllegalAccessException]
	[java.lang.reflect.Field]类的主要作用=
		可以取得指定成员的类型;
		可以直接操作属性;不再需要通过[java.lang.reflect.Method]类的方法set或get属性;但只能操作非private属性;
			可通过[java.lang.reflect.AccessibleObject]类中[public void setAccessible(boolean flag) throws SecurityException]方法设置是否封装,可以取消封装(不建议);

==========总结
	1.反射可以实例化对象(代替new关键字);
	2.简单Java类的setter和getter标准命名方式使程序更加清晰,方便使用反射;
	3.使用了反射,整个程序变得非常容易操作,省去了重复调用setter方法设置内容等重复操作;
	另补充-实例化对象的三种方式=
	1.new关键字;
	2.[java.lang.Object]类中[clone()]方法;
	3.反射;
	
	[java.lang.reflect.AccessibleObject]类是以下三个类的共同父类=
	[java.lang.reflect.Constructor<T>]、[java.lang.reflect.Method]、[java.lang.reflect.Field]
*/

/*
==========JSP语法对反射的支持(了解)
	JSP语法中有三个与反射有关的标签,用于进行JavaBean(简单Java类)操作;标签如下=
	定义JavaBean=[<jsp:useBean id="对象" class="包.类" scope="范围"/>]
		说明="id"可定义四种属性范围中的属性名称;"scope"一共可定义四种范围=page、request、session、application;
		设置属性=<jsp:setProperty property="*或属性名称" param="参数名称" value="数据" name="id的内容"/>
		说明="name"属性表示要操作的对象名字(对应<jsp:useBean>标签中"id"定义的内容);
		取得属性=<jsp:getProperty property="属性名称" name="id的内容"/>
		例=	<% page import="cn.mldn.vo.Dept" %>
		<% Dept dept = new Dept()%>
		以上代码利用标签完成=<jsp:useBean id="dept" class="cn.mldn.vo.dept" scope="page"/>
		<% dept.setDeptno(Integer.parseInt(request.getParameter("deptno")))%>
		以上代码利用标签完成=<jsp:setProperty property="*" name="dept"/>
		<%=dept.getDeptno()%>
		以上代码利用标签完成=<jsp:getProperty property="deptno" name="dept"/>
	总结=此标签就是利用了反射机制完成的,且标签也符合于反射机制的特点;如标签中[class="cn.mldn.vo.dept"],是[包.类]的形式,是反射的一个重要特征;但此标签不能再用于现在的开发中(可以借鉴它的方式),原因如下=
	原因1=使用MVC设计模式,而不使用此种标签形式(JSP+JavaBean);
	原因2=这种标签数据自动转换支持度不高,没有数据验证,无法控制数据错误(如数据类型转换限制的控制),出了错误只能显示在页面上;
*/

/*
==========[Annotation]与反射应用
	说明=Java和Servlet中的Annotation的使用,带来了好处=节约了代码的检查时间、节约了配置文件的编写;尤其在Servlet配置过程中,解决了配置文件(web.xml)过多的问题;
	[java.lang.Class<T>]类中的方法=
		取得类上配置的全部Annotation=[public Annotation[] getAnnotations()];
		取得类上配置的一个Annotation=[public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass)];
		取得方法上定义的Annotation=使用[java.lang.reflect.AccessibleObject]类中的[public Annotation[] getAnnotations()]方法;
=====自定义Annotation类=(详见="DemoAnnotation.java")
		说明=Annotation接口是所有自定义Annotation类的父类,如果选哪个要取得子类自定义的操作,必须向下强制转型;自定义Annotation类需满足一下两个要求=
		1.需要使用"@interface"关键字组合;此关键字类似implements Annotation接口操作;
		2.同时必须明确的设置Annotation的运行范围;运行范围详见在枚举类[java.lang.annotation.RetentionPolicy]中定义有三个范围=
			RetentionPolicy.CLASS=将Annotation保存在类之中;
			RetentionPolicy.RUNTIME=在程序运行的时候起作用;如@Deprecated=RetentionPolicy.RUNTIME
			RetentionPolicy.SOURCE=在源代码之中起作用;如@Override="RetentionPolicy.SOURCE"
=====Annotation的应用=详见截图;
		说明=拿工厂模式举例,利用反射实现了工厂模式中的对象的实例化,成功的实现了操作的解耦合;
			Annotation的使用很麻烦,所以一般出现在成熟的开发框架之中,开发者很少会接触到这样的开发操作;
=====总结=
	Annotation虽然好用,但是开发比较麻烦,且实际开发中必须要有容器支持,如Servlet中的Annotation要和Web容器结合后才有意义;
*/

/*
==========[ClassLoader]类加载器=[java.lang.ClassLoader]=[public abstract class ClassLoader extends Object]
	说明=类加载器是指可以加载类文件(.class)的程序;之所以使用类加载器,主要是为了方便从远程服务器端加载类文件;
		[ClassLoader]是类加载器,默认情况下只能加载CLASSPATH中的程序类;
		为了程序的安全考虑,Java自带的类无法被加载器控制,因为Java为了保证系统安全,提供了一个概念:双生加载,只要是Java系统类库使用的都是自己的加载器,外部无法控制;
		为了程序的安全考虑,如果自定义了一个和Java系统类库相同名称的类,也不会被加载,因为默认加载的是Java系统类库中的类;
		Java系统加载器分为两种=
			系统加载器=sun.misc.Launcher$AppClassLoader@73d16e93;
			扩展加载器=sun.misc.Launcher$ExtClassLoader@74a14482;
			说明=自定义的类都是利用扩展加载器完成加载的;
=====定义自己的类加载器
	说明=[ClassLoader]类是一个抽象类,但没有抽象方法,目的是为了让用户继承这个类,但不能直接使用其中的方法;
		如果已经得到类的文件信息,可以[ClassLoader]类的以下方法进行加载;
		使用类加载器的目的是可以通过远程将类加载进程序;远程指=不在CLASSPATH路径中,如服务器远端中;
	方法=
		加载一个类=[public Class<?> loadClass(String name) throws ClassNotFoundException]
		因为是需要远程加载,需要从远端读取类文件,所以需要使用[java.io.ByteArrayOutputStream]类中[public byte[] toByteArray()]方法;
		然后将字节数组转换为类文件=[protected final Class<?> defineClass(String name,byte[] b,int off,int len,ProtectionDomain protectionDomain) throws ClassFormatError]]
=====总结
	使用类加载器之后打破了CLASSPATH的限定格局;可以将类存放在远程随意路径或服务器端,客户端通过类加载器找到该类并加载进来运行;
	类加载器属于扩充功能;适用于某些类经常会改变,存放在服务器端,客户端远程加载时较为方便的情况;
*/

/*
==========代理设计模式
	特点=一个真实业务主题只完成核心操作,而与之所有辅助的功能都有代理类完成;
		例=数据库更新中的事务处理操作,事务处理属于与核心业务有关的功能;DAO接口类中doXxxx开头的都是更新操作;
			更新操作必须有事务处理操作,属于真实主题类;
			查询操作不需要事务处理,辅助功能,属于代理主题类;
=====动态代理设计模式
	说明=此部分内容仅作熟悉概念使用,实际开发中使用成熟框架实现;使用一个代理类实现所有被代理的操作;需要使用反射;
		利用[java.lang.reflect Interface InvocationHandler]接口的如下方法实现=
		方法=代理类中调用真实主题类的操作方法=[public Object invoke(Object proxy,Method method,Object[] args) throws Throwable]
			"Object proxy"=表示代理类的对象,一般没用;
			"Method method"=表示现在正在调用的方法;
			"Object[] args"=表示方法里面接收的参数;
		以上方法没有所对应的真是对象,需要在创建这个类对象的时候设置好;要想找到代理对象需要使用[java.lang.reflect.Proxy]类动态创建,使用此类如下方法=
		方法=[public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) throws IllegalArgumentException]
			"ClassLoader loader"=指的是取得对象的加载器;
			"Class<?>[] interfaces"=代理设计模式的核心是围绕接口进行的,所以此处必须取出全部的接口;
			"InvocationHandler h"=代理的实现类;
=====利用CGLIB实现动态代理设计模式
	说明=代理设计模式有一个硬性要求=代理类必须有接口;开源社区中提供有一个组件包=CGLIB,利用这个包可以在没有接口的情况下实现代理设计模式,它是模拟的类,作为真实类和代理类中间关系桥梁;
		使用[cglib-nodep-3.1.jar]必须首先清除对应关系=
			[Proxy]类=对应[net.sf.cglib.proxy.Enhancer]
			[InvocationHandler]=对应[net.sf.cglib.proxy.MethodInterceptor]
			真实主题调用功能=对应[net.sf.cglib.proxy.MethodProxy]
*/

/*
==========反射与简单Java类
=====设置单级属性
	说明=详见截图;通过反射取得类-方法-属性,并设置属性;
		key="对象名称.属性名称";只有一级属性信息;
		value="属性值";

=====设置多级属性
	说明=详见截图;
	例=一个雇员属于一个部门,一个部门属于一个公司,找到公司这个对象,并设置属性.
		"雇员.部门.公司.姓名";多级属性信息;

=====设置基本类型数据内容
	说明=通过反射实现简单Java类基本数据类型判断及转型,定义一个工具类,减少重复代码的出现;

=====设置数组数据内容
	说明=通过反射实现简单Java类数组数据类型判断及转型,定义一个工具类,减少重复代码的出现;
*/

/*
==========反射实例=反射+Servlet

=====利用反射开发[DispatcherServlet]工具类(抽象类)
	说明=传统MVC设计模式的缺陷=
		1.代码总是在复制、重复编写;
		2.代码的状态增加时需要明确的自己编写if语句;
			每一个servlet都是多业务处理,每个业务在程序中都增加if...else判断区分;
		3.在工厂类不写相应的方法无法取得明确的实例化对象;
		4.msg与url不断定义信息;
			在所有更新操作完成后都需要设置msg与url属性到forward.jsp页面上;
		5.request、response在参数上一直重复出现;
			如=在使用SmartUpload时发现,接收参数操作需要传入HttpServletRequest、HttpServletResponse两个对象,不需要接收参数的操作只需传递HttpServletRequest一个对象;
		6.所有的接受参数最终都要变为简单java类;
			导致验证太麻烦、数据类型转换的步骤太重复;
		通过发现以上问题,利用反射机制形成一个工具处理类,可以解决以上所有的MVC开发表面问题;
	说明=在MVC设计模式中,几乎所有的Servlet都可能涉及如下的功能=
		1.处理请求参数,并将其以VO类的形式操作;
		2.进行数据的验证处理;
		3.进行文件的上传处理操作;
		4.数据的分页显示;
		5.所有的跳转路径和提示信息都写在了Servlet中,一旦改变提示信息或跳转路径,就得修改Servlet源代码;
	说明=理想中的Servlet应该处理的功能=
		1.得到一个操作的VO类对象;
		2.调用业务层进行业务处理;
		3.跳转到JSP页面;
	步骤1=编写[UtilDispatcherServlet.java]Servlet工具类;
	步骤2=编写[DemoDispatcherServlet.kava]Servlet类,并继承[UtilDispatcherServlet.java];

=====反射操作资源文件
	说明=使用资源文件(*.properties)配置Servlet跳转路径,资源文件内容使用"key-value"的形式描述;
		操作资源文件,使用[ResourceBundle]、[Properties]这两个类完成;推荐[ResourceBundle]类,因为此类较方便,读取时不需要编写".properties"后缀;
		资源文件读取方式=
			方式1=每一次都重新读取资源文件,如果项目运行过程中资源文件进行了修改,可以实现动态加载;
			方式2=仅在Servlet初始化时读取一次资源文件,如果修改了则需要重新启动服务器;
			因为资源文件很少会发生修改,所以选择方式2即可,所有的资源文件都保存在CLASSPATH之中,例="src"文件夹下的java程序/资源文件,会自动保存在"WEB-INF/classes"目录中,此目录就是一个CLASSPATH;
	步骤1=定义两个资源文件=[Messages.properties]、[Pages.properties]
	步骤2=在[Servlet]中使用初始化方法[init()]加载"*.properties"配置文件;
	总结=以后的页面提示信息都应该在资源文件中编写;

=====自动赋值操作
	说明=在整个开发中,大部分情况都会将用户从JSP页面传递的数据转换为简单Java类的形式进行操作;
		为了统一操作,会在JSP页面中用户填写的信息用统一的格式保存,这样传递过来后方便统一处理;
		如=	第一步=在JSP文件中<input type="text" name="dept.dname" id="dept.dname" value="部门名称">;其中属性名称中带有"."的是需要自动转换操作的数据;
			第二部=在[UtilDispatcherServlet.java]中对JSP传递来的数据进行处理;

=====完善上传操作
	说明=页面表单数据分两种情况=
		1.已封装=如果页面表单使用了"enctype"先进行了封装,那么封装后的"request"对象将无法取得全部的请求参数,必须通过"SmartUpload"完成;
			区分表单是否被封装=通过请求的文件头信息、上传的类型;例=[request.getContentType().contains("multipart/form-data")];
		2.未封装=使用普通"request"对象取得;

=====处理上传文件操作
	说明=如果要处理文件上传操作,需在程序中为上传的文件生成文件名称,且需考虑一个或多个文件同时上传;
		设置上传文件的名称=
			情况1=若上传的文件是单个文件,定义一个可以创建单个上传文件名称的方法"createSingleFileName()";
			情况2=若上传的文件是多个文件,定义一个可以创建多个上传文件名称的方法"createMultiFileName()",返回MAP集合;
		设置上传文件的保存目录=
			说明=如一个程序有多张表,都有上传文件操作;此时由父类定义"取得上传文件的保存目录"功能的抽象方法"getUploadDirectory()",然后由不同的子类实现比较好;
		保存上传文件=
			定义"saveFile()"和"upload()"方法实现;
		上传文件删除=
			定义"deleteFile()"方法实现;

=====反射验证
	说明=所有的数据都需要进行验证,尤其是需要进入到数据库中的数据;
		1.每个Servlet的验证规则各不相同,具体的验证规则有各Servlet完成比较好;
			在Servlet中定义需要验证内容;例=[private final String insertVlidate = "dept.deptno|dept.dname|dept.loc|dept.company.title";]
		2.在[UtilDispatcherServlet.java]中定义取出验证数据的方法"validateRequest()";
		3.定义工具类[UtilValidateParameter.java]、[UtilValidate.java]实现具体验证参数及验证规则;
	总结=通过以上几个工具类,以后程序的验证操作交由其完成,并将验证结果自动保存在[UtilDispatcherServlet.java]类中;

=====分页处理
	说明=各个页面中分页功能结构都是类似且重复的;
		1.因为不同的分页在进行搜索的列和默认列的定义上不同,所以可以在[UtilDispatcherServlet.java]中增加两个抽象方法"getColumnData()"和"getDefaultColumn()",具体的实现由子类完成;
		2.在整个数据表的CRUD操作中,只有列表操作需要分页,其他操作不需要;所以可以在[UtilDispatcherServlet.java]中定义一个方法"handleSplit()"处理分页;
*/

/*
=====工具类
	[UtilDispatcherServlet.java]=Sevlet工具类;负责=
		1.初始化"init()"加载配置文件信息,并根据配置信息实现不同Serlvet功能跳转及数据回传"getPath()"、"getMsg()";
		2.通过"doGet()"、"doPost()"方法接收页面传递过来的数据并处理;
	[UtilString.java]=通过其中的"initcap()"方法实现将传递进来字符串首字母大写;
	[UtilAttributeType.java]=通过其中的"handleParameteter()"方法实现将传递进来的数据进行分析,返回可调用的属性的名称及类型;
	[UtilBeanOperate.java]=通过其中的"handleParameteter()"方法和"setValue()"方法实现对VO对象进行数据取得、设置功能;
*/
