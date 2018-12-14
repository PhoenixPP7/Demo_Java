package _00_Java;

public class Java2 {
	public static void main(String[] args) {

	}
}

/*
==========仅需了解内容
=====[Runtime]类
	说明=每一个JVM进行都会存在一个[Runtime]类对象,主要功能是取得与运行环境有关的属性或创建新的进程等操作,[Runtime]类是直接与本地运行有关的所有相关属性的集合;
		因为要保证在整个进程中只有唯一的一个[Runtime]类对象,所以[Runtime]类的构造方法被私有化了,属于单例设计模式应用;
	方法=
		取得[Runtime]类实例化对象=[public static Runtime getRuntime()];
		返回所有可用内存空间=[public long totalMemory()];
		返回最大可用内存空间=[public long maxMemory()];
		返回剩余内存空间=[public long freeMemory()];
		释放垃圾空间=[public void gc()];
		执行本机某程序进程=[public Process exec(String command) throws IOException];
	说明=GC(Garbage Collector)垃圾收集器
		GC可以释放无用的内存空间;由系统不定期自动回收,或手动调用[Runtime]类中的[gc()]方法回收;
=====[System]类
	方法=
		取得当前系统时间=[public static long currentTimeMillis()];单位=毫秒;
		释放垃圾空间=[public static void gc()];此方法是调用了[Runtime]类中的[gc()]方法;
		产生垃圾的对象回收前的收尾方法=[protected void finalize() throws Throwable];
=====对象克隆
	说明=克隆指的是对象的复制操作;对象克隆操作的理论价值大于实际价值,实际工作很少会用到;
	方法=
		[Object]类提供克隆的方法=[protected Object clone() throws CloneNotSupportedException]
		说明=当要使用对象克隆的类没有实现[Cloneable]接口时会抛出异常[CloneNotSupportedException];
			[Cloneable]接口内没有任何属性或方法,为标识接口;

=====国际化程序(了解)
	说明=根据当前的语言环境读取指定的语言资源文件;应用开发仅涉及编写资源文件,不涉及进行资源文件操作;
		资源文件是指[*.properties],资源文件命名标准和Java类一致,要求每个单词首字母大写,里面内容按照"key=value"的形式保存;中文信息,必须将其变为UNICODE编码;
		[ResourceBundle]类可以读取在制定的CLASSPATH下的资源文件,读取时不需要添加后缀".properties";
		[MessageFormat]类实现动态的占位文本格式化功能;
		[Locale]类用于读取资源文件的语言环境;
=====[java.util.ResourceBundle]类=是资源文件专门读取的类;
	方法=
		根据当前语言环境取出=[public static final ResourceBundle getBundle(String baseName)];参数"baseName"是properties文件的名字,例=[Message.properties]中的"Message";
		设置指定语言环境=[public static final ResourceBundle getBundle(String baseName,Locale locale)]
		通过以上两个方法取得[ResourceBundle]类对象后可以通过以下方法读取数据=
			简单读取=[public final String getString(String key)]
=====[java.text.MessageFormat]类=[java.text]包是专门负责国际化处理的程序包,在这个包里面有一个专门处理占位数据的操作类[java.text.MessageFormat];此类有如下方法=
		格式化文本=[public static String format(String pattern,Object... arguments)]
		占位符={数字};例=[欢迎光临：{0}，现在的时间是：{1}！];
=====[java.util.Locale]类=读取资源文件的语言环境;
	方法=
		构造方法=[Locale(String language, String country)];通过构造方法读取中文/英文资源文件;
		取得当前语言环境=[public static Locale getDefault()];
	语言编码=中文=[zh_CN];美国=[en_US];例=[Message_zh_CN.properties];

========================================Java-网络
====================TCP
==========TCP的Server端:
第一步:new一个ServerSocket并监听某端口(建议端口选择:1024~65530);
第二步:调用accept()方法,用来接收某个连接;
第三步:接收到某个连接之后,通过InputXXXXX和OutputXXXXX开始通话;
第四步:关闭Socket和InputXXXXX和OutputXXXXX;
==========TCP的Client端:
第一步:new一个Socket并通过IP地址和端口连接到服务器端对应Socket;
第二步:连接之后,通过InputXXXXX和OutputXXXXX开始通话;
第三步:关闭Socket和InputXXXXX和OutputXXXXX;
====================UDP
==========UDP的Server端:
第一步:new一个DatagramSocket,new一个字节数组,new一个DatagramPacket;
第二步:DatagramPacket接收任何东西放入字节数组中,通过DatagramSocket的receive接收数据;
第三步:处理接收的数据;
==========UDP的Client端:
第一步:new一个DatagramPacket,并装入数据,将数据通过ByteArrayOutputStream转换成字节数组;
第二步:将字节数组装入包中,通过DatagramSocket的send()方法将包发送出去;

*/