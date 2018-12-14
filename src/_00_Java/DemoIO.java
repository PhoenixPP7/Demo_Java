package _00_Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DemoIO {
	public static void main(String[] args) throws Exception {
		/*
		long start = System.currentTimeMillis();	//取得程序刚开始执行时的时间;
				
		File inputFile = new File("d:" + File.separator + "my.jpg");	// 加载要读取的文件
		if (!inputFile.exists()){		//判断源文件是否存在
			System.out.println("源文件不存在,请确认路径!");
			System.exit(1);		//程序退出
		}
		
		File outputFile = new File("d:" + File.separator + "Hello" + File.separator + "World.JPG");	//加载要输出的文件
		if(!outputFile.getParentFile().exists()) {	//判断目标文件路径是否存在
			outputFile.getParentFile().mkdirs();	//如果不存在创建父路径
		}
		
		InputStream input = new FileInputStream(inputFile);
		OutputStream output = new FileOutputStream(outputFile);
		
		int temp = 0 ;	//用于保存每次读取的个数;
		byte data [] = new byte [1024];	//每次读取1024个字节;
		//	将每次读取的数据保存在字节数组中,且返回读取的个数;
		while((temp = input.read(data)) != -1) {	//每次读取1024个字节,直到文件结尾返回"-1";
			output.write(data,0,temp);	//输出数组;
		}
		
		input.close();
		output.close();
		long end = System.currentTimeMillis();//取得程序执行完成拷贝工作时的时间;
		System.out.println("拷贝所花费的时间 = " + (end - start));

		System.out.println("inputFile - 文件大小 = "+new BigDecimal((double)inputFile.length() / 1024 / 1024).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP) + " MB");
		System.out.println("inputFile - 文件修改日期 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(inputFile.lastModified())));
		*/
		
		//标准键盘输入格式
		//[System.in]是字节输入流[InputStream]类对象
		//利用转换流[InputStreamReader]类将字节流转换为字符流;
		//[BufferedReader]的构造方法接收字符流[Reader]类对象;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入数据 = ");
		String str =buf.readLine();//[readLine()]方法以回车作为输入结束
		System.out.println("输入的内容为 = " + str);
	}
}

/*
==========JavaIO
=====说明=抽象类定义的抽象方法会根据实例化子类不同,也会完成不同的功能;Java中对文件及文件内容的开发功能,集中在[java.io]包中,由其中五个核心类一个核心接口实现;
		[java.io.File];此类是唯一一个与文件本身操作有关的类,但不涉及文件的具体内容操作;
		[java.io.InputStream];字节输入流;
		[java.io.OutputStream];字节输出流;
		[java.io.Reader];字符输入流;
		[java.io.Writer];字符输出流;
		[java.io Interface Serializable];
=====文件内容输入、输出操作一般按照如下步骤进行=
			1.通过[File]类定义一个要操作的文件路径(操作的是文件时需此步,否则省去);
			2.通过字节流或字符流的子类对象为父类对象实例化;
			3.进行数据的读(输入)、写(输出)操作;
			4.数据流的操作属于资源操作,资源操作必须关闭;
			5.操作输入流和输出流时,都使用了向上转型,好处是操作模式得到了统一;

==========[File]=文件和目录路径操作类=[java.io.File]=[public class File extends Object implements Serializable, Comparable<File>]
	说明=此类可操作包括文件(如:"*.jpg")和目录路径(如:文件夹);此类是唯一一个与文件本身操作有关的类,如文件的创建、删除等操作;但不涉及文件的具体内容操作;
		补充说明=在进行[java.io]操作的过程中,会出现延迟的情况,因为Java程序是通过JVM间接的调用操作系统中文件处理函数进行文件处理操作,所以会出现延迟;所以创建和删除同名文件应设置间隔时间;
	常量=
		路径分隔符常量=[public static final String separator];使用此常量可解决不用操作系统中路径分隔符不同的问题=Windows使用的是"\",Linux使用的是"/";
	方法=
		*设置完整路径(构造方法)=[public File(String pathname)];大部分情况下使用此方法;
		设置父路径及子文件路径(构造方法)=[public File(String parent,String child)];主要应用于Android系统;
		创建文件=[public boolean createNewFile() throws IOException];
			说明=以下情况会出错=1.目录不存在/不能访问;2.文件名称重名或错误的文件名称;
		*删除文件=[public boolean delete()];
		*判断文件是否存在=[public boolean exists()]
		*取得父路径文件=[public File getParentFile()]
		创建父目录路径=[public boolean mkdir()]
		*创建多级父路径目录=[public boolean mkdirs()]
		取得文件大小=[public long length()];转换为四舍五入并保留两位小数,例=[new BigDecimal(取得的long类型文件大小数据).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP)];
		判断是否是文件=[public boolean isFile()]
		判断是否是目录路径=[public boolean isDirectory()]
		取得最近一次修改日期=[public long lastModified()];转换为标准日期格式,例=[new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(取得的long类型日期数据))]
		取得文件目录路径=[public String getPath()];
		列出目录路径下的信息=[public String[] list()]
		*列出所有的信息,以File类对象数组包装返回=[public File[] listFiles()]
	总结=
		1.[File]类只是用来操作文件(文件夹目录、文件)的,不涉及文件中的具体内容数据;
		2.[File]类中的重要方法已用"*"标记;
		3.[File]类操作路径的时候,分隔符应使用[File对象.separator]常量;

==========[OutputStream]=字节输出流(父类)=[java.io.OutputStream]=[public abstract class OutputStream extends Object implements Closeable, Flushable]
	说明=进行字节数据输出的类,此类是一个抽象类,如果要想为抽象类进行对象的实例化操作,那么只能使用抽象类的子类,一般进行文件操作使用[FileOutputStream]子类;
	方法=
		*输出部分字节数组=[public void write(byte[] b,int off,int len) throws IOException];
		输出全部字节数组=[public void write(byte[] b) throws IOException];
		输出单个字节=[public abstract void write(int b) throws IOException];注意参数类型是int,因为使用int的情况较多,所以设计之初就将参数设置为了int,利用byte自动向上转换int,最大值127,否则出错;
		强制清空缓冲区资源(一次性将资源全部传输过去)=[public void flush() throws IOException];
		关闭资源访问=[public void close() throws IOException];
=====[FileOutputStream]=文件字节输出流(子类)=[java.io.FileOutputStream]=[public class FileOutputStream extends OutputStream]
	说明=因为要使用父类对象,所以子类实例化对象后向父类向上转型,使用的是子类的构造方法;向上转型之后使用的普通方法是父类定义的,子类构造方法定义如下=
	构造方法=
		*创建或覆盖已有文件,向该文件输出保存的内容=[public FileOutputStream(File file) throws FileNotFoundException]
		文件内容追加=[public FileOutputStream(File file,boolean append) throws FileNotFoundException]
=====[Closeable]和[Flushable]接口=补充=[OutputStream]类实现了[Closeable]和[Flushable]两个接口(因为此类本身的方法和此两个接口提供的方法功能覆盖,所以一般不使用此两个接口),具体如下=

==========[InputStream]=字节输入(读取)流(父类)=[java.io.InputStream]=[public abstract class InputStream extends Object implements Closeable]
	说明=进行字节数据输入的类,此类是一个抽象类,如果要想为抽象类进行对象的实例化操作,那么只能使用抽象类的子类,一般进行文件操作使用[FileInputStream]子类;
	方法=
		读取单个字节=[public abstract int read() throws IOException];
			返回值=返回读取的字节内容,如果读取的没有内容了,返回"-1";
		*将读取的数据保存在字节数组中=[public int read(byte[] b) throws IOException]
			返回值=返回读取的数据长度"参数=byte[] b",如果读取到结尾了,返回"-1";
		将读取的数据保存在部分字节数组中=[public int read(byte[] b,int off,int len) throws IOException]
			返回值=返回读取的部分数据长度,如果读取到结尾了,返回"-1";
=====[FileInputStream]=文件字节输入(读取)流(子类)=[java.io.FileInputStream]=[public class FileInputStream extends InputStream]
	说明=因为要使用父类对象,所以子类实例化对象后向父类向上转型,使用的是子类的构造方法;向上转型之后使用的普通方法是父类定义的,子类构造方法定义如下=
	构造方法=
		读取已有文件内容=[public FileInputStream(File file) throws FileNotFoundException]
=====[Closeable]接口=补充=[InputStream]类也实现了[Closeable]接口,同[OutputStream]一般不使用此接口;

==========[Writer]=字符输出流(父类)=[java.io.Writer]=[public abstract class Writer extends Object implements Appendable, Closeable, Flushable]
	说明=此类较[OutputStream],最大的好处是不需要转换就可以直接输出字符串及字符;此类是一个抽象类,如果要想为抽象类进行对象的实例化操作,那么只能使用抽象类的子类,一般进行文件操作使用[FileWriter]子类;
	方法=
		输出字符串=[public void write(String str) throws IOException]
		输出全部字符数组=[public void write(char[] cbuf) throws IOException]
=====[FileWriter]=文件字符输出(子类)=[java.io.FileWriter]=[public class FileWriter extends OutputStreamWriter]
	说明=为[Writer]类实例化使用[FileWriter]子类完成;
	构造方法=
		创建或覆盖已有文件,向该文件输出保存的内容=[public FileWriter(File file) throws IOException]
=====[Appendable]接口=补充=[Writer]类实现了[Appendable]=

==========[Reader]=字符输入(读取)流(父类)=[java.io.Reader]=[public abstract class Reader extends Object implements Readable, Closeable]
	说明=此类较[IutputStream],最大的好处是不需要转换就可以直接输入字符串及字符;此类是一个抽象类,如果要想为抽象类进行对象的实例化操作,那么只能使用抽象类的子类,一般进行文件操作使用[FileReader]子类;
	方法=
		读取内容到字符数组=[public int read(char[] cbuf) throws IOException]
			返回值=表示读取的数据长度,如果已经读取到了结尾,返回"-1";
=====[FileReader]=文件字符输入(子类)=[java.io.FileReader]=[public class FileReader extends InputStreamReader]
	说明=为[Reader]类实例化使用[FileReader]子类完成;
	构造方法=
		读取已有文件内容=[public FileReader(File file) throws FileNotFoundException]
=====[Readable]接口=补充(了解)=[Reader]类实现了[Readable]=[java.lang Interface Readable]=[public interface Readable]
	方法=[int read(CharBuffer cb) throws IOException];参数"CharBuffer"是[java.nio.CharBuffer],"nio"是新io,主要解决服务器通讯延迟操作;

==========补充=字节流和字符流涉及的接口
=====接口[Closeable]=[java.io Interface Closeable]=[public interface Closeable extends AutoCloseable]
		说明=此接口主要实现资源关闭功能;此接口又继承了[AutoCloseable]父接口,父接口提供有自动关闭机制,但一般不用;
		方法=关闭资源访问=[public void close() throws IOException]
=====接口[Flushable]=[java.io Interface Flushable]=[public interface Flushable]
		说明=此接口主要实现资源清空功能;
		方法=清空资源(一次性将资源全部传输过去)=[void flush() throws IOException]
=====接口[Appendable]=[java.lang Interface Appendable]=[public interface Appendable]
		方法=
			追加一个字符=[Appendable append(char c) throws IOException]
			追加一个字符串=[Appendable append(CharSequence csq) throws IOException]
			追加一个字符串的部分数据=[Appendable append(CharSequence csq,int start,int end) throws IOException]
				
==========字节流与字符流转换(了解)
	说明=字节流转换为字符流=此种转换意义不大,只有需要将字节流转换为字符流方便处理中文数据时使用;
=====[InputStreamReader]=[java.io.InputStreamReader]=[public class InputStreamReader extends Reader]
	构造方法=
		接收[InputStream]转换为[Reader]=[public InputStreamReader(InputStream in)]
=====[OutputStreamWriter]=[java.io.OutputStreamWriter]=[public class OutputStreamWriter extends Writer]
	构造方法=
		接收[OutputStream]转换为[Writer]=[public OutputStreamWriter(OutputStream out)]
=====总结=只有处理中文数据时使用需要将字节流转换为字符流;[InputStreamReader]和[OutputStreamWriter]两个转换类都是字符流的子类,属于字符流和字节流沟通的桥梁;
=====字节流和字符流的继承结构
	例=[FileOutputStream]
		java.lang.Object
			java.io.OutputStream
				java.io.FileOutputStream
	例=[FileWriter]=
		java.lang.Object
			java.io.Writer
				java.io.OutputStreamWriter
					java.io.FileWriter
	通过以上继承结构,发现字符流是字节流经过转换而来的;
	因为文件保存在磁盘中,磁盘中都是以字节的形式保存文件的,所以在使用字符流读取的时候,实际是对字节数据进行读取的,只不过这中间的转换过程被操作系统隐藏了,在缓冲区进行了数据的操作;
	总结=从电脑磁盘或网络服务中交互读取的数据都是字节数据,字符是字节处理后的数据,只不过这个处理过程被隐藏了;

==========综合实战=字节流实现文件拷贝
	说明=详见"DemoIO.java";
	注意=读取文件形式,"while((temp = input.read()) != -1)"=每次读取1个字节,此种形式太慢了,建议使用"input.read(1024)"比较适中;
		*将读取的数据保存在字节数组中=[public int read(byte[] b) throws IOException]
		*输出部分字节数组=[public void write(byte[] b,int off,int len) throws IOException];

==========字符编码
	说明=最常见的编码=
		UTF编码(UTF-8)=融合了ISO8859-1和UNICODE编码的特点;开发使用此编码;
		UNICODE=十六进制编码,会造成传输的无用数据过多;
		IOS8859-1=国际编码,可以描述任何的文字信息;---常见于浏览器网站;
		GBK、GB2312=中文国际编码,GBK含简体和繁体,GB2312只含简体;---有局限,不使用;
		Eclipse默认会使用本地国家编码,中国=GBK;
	说明=乱码=本质是因为编码和解码的字符集不统一;例=编码时使用"GBK",打开解码时使用"IOS8859-1";

==========内存操作流(了解)
	说明=当应用AJAX+XML(JSON)时会用到内存流;内存流可以实现IO操作;当某应用需要使用输入流和输出流进行操作,但又不想产生文件时,可以使用内存实现输入与输出操作,这就是内存流;
=====字节内存流(也继承自[java.io.OutputStream]和[java.io.InputStream])=
	字节数组内存输出流=[java.io.ByteArrayOutputStream]
		构造方法=从内存输出数据=[public ByteArrayOutputStream()]
		*方法=将内存中字节数据转换为字节数组=[public byte[] toByteArray()];此方法可以实现文件同时读取;
	字节数组内存输入流=[java.io.ByteArrayInputStream]
		构造方法=将要操作的数据设置到输入流=[public ByteArrayInputStream(byte[] buf)]
=====字符内存流(也继承自[java.io.OutputStream]和[java.io.InputStream])=
	字符数组内存输出流=[java.io.CharArrayWriter]
	字符数组内存输入流=[java.io.CharArrayReader]

==========打印流
	说明=[OutputStream]输出数据,如要输出String数据,需将String转换为字节数组后输出;如需输出int数据,需将int转换为String,再转换为字节数组输出;boolean和double数据类似;
		所以[OutputSteam]输出不同类型数据时较麻烦,为了解决输出数据时功能不足,可以使用专门处理输出数据的类=
=====打印字节流=[java.io.PrintStream]---继承自[java.io.OutputStream]
	说明=此类提供有一系列[print()]和[println()]方法,可以方法可以进行各种数据类型的输出,替代[write()]方法;
	构造方法=[public PrintWriter(OutputStream out)]
=====打印字符流=[java.io.PrintWriter]
=====打印流-格式化输出(了解)
	[java.io.PrintWriter]
	方法=
		格式化输出=[public PrintWriter printf(String format,Object... args)]
			需要使用标记=整数"%d"、字符串"%s"、小数"%m.nf"、字符"%c";
	[String]类也咋JDK1.5新增了格式化功能;
	方法=
		格式化字符串=[public static String format(String format,Object... args)]
=====总结=实际开发中,只要是由程序输出内容,都采用打印输出流完成;

==========[System]类对IO操作的支持(了解)
	说明=[System]类为支持IO操作,提供有3个常量=
		输出到标准输出设备(显示器)=[public static final PrintStream out]---此为[PrintStream]类对象,例=[System.out();]
		输出错误信息=[public static final PrintStream err]---此为[PrintStream]类对象,例=[System.err();]
		从标准输入设备读取(键盘)=[public static final InputStream in]---此为[InputStream]类对象,例=[System.err();]

==========缓冲输入流=[BufferedReader]
	说明=此为常用工具类,解决数据的乱码问题,键盘输入到程序使用此类解决,标准使用格式见截图;有点之一是接收的参数是[String],可以使用正则进行操作验证;
	字符缓冲区流=*[BufferedReader]*、[BufferedWriter]
	字节缓冲区流=[BufferedInputStream]、[BufferedOutputStream]
		*[BufferedReader]类=[java.io.BufferedReader]此类是[java.io.Reader]的子类
			构造方法=[public BufferedReader(Reader in)],参数是字符输入流[Reader]类对象,
			方法=
				读取一行数据=[public String readLine() throws IOException],读取一行数据,以分隔符换行;
	总结=与[InputStream]([Reader])类相比,使用[BufferedReader]类进行文件读取时更方便;

==========扫描流=[Scanner]
	说明=[BufferedReader]类的问题是读取数据只能返回字符串类型;读取分隔符是固定的,一行一行;
		[java.util.Scanner]专门解决输入流的操作问题;
	构造方法=
		[public Scanner(InputStream source)],接收[InputStream]类对象,可以接受它的任意子类;
	方法=
		判断是否有指定数据=[public boolean hasNextXxx()];例=[public boolean hasNextDouble()]
		取出数据=[public Xxx数据类型 nextXxx()];例=[public double nextDouble()]
		设置分隔符=[public Scanner useDelimiter(String pattern)];读取文件时需要,否则文件中的空格和换行符都会消失,例=[Scanner.useDelimiter("\n")];
	总结=此类与[BufferedReader]相比,更加简便,更加直观;

==========对象序列化(了解)
	说明=对象序列化是指将保存在内存中的对象数据转换为二进制数据流进行传输的操作;只有需要传输的对象所在的类才需要进行序列化操作,该类需实现[java.io Interface Serializabl]接口;
		[Serializabl]接口没有任何方法,它是一个标识接口,表示一种能力;实现了[Serializabl]接口的对象就可以实现二进制传输了;
	序列化类=[java.io.ObjectOutputStream];将对象转换为指定格式的二进制数据;
	反序列化类=[java.io.ObjectInputStream];将序列化后的对象转换回对象内容;
	[transient]关键字,被此关键字修饰的属性将无法被序列化;


==========总结
	说明=进行文件内容的操作指输出、输入操作,输出是指程序向客户端输出内容,输入是指客户端向程序输入内容;有两种途径=字节流、字符流;一个中文字符=2个字节;"\r\n"=换行;
	实际开发中=输出数据时使用打印流[PrintStream]和[PrintWriter],输入数据是使用扫描流[Scanner];
		[InputStream]类的功能不足被[Scanner]类解决了;
		[OutputStream]类的功能不足被[PrintStream]类解决了;
		[Reader]类的功能不足被[BufferedReader]类解决了;
		[Writer]类的功能不足被[PrintWriter]类解决了;


		
==========字节流和字符流的区别?
=====字节流
	字节流直接与终端进行数据交互;
	字节流输出的时候没有关闭输出流,内容依然可以正常输出;
	开发中字节数据处理情况较多,如=图片、音乐、电影、文字;
=====字符流	
	字符流需要将数据经过缓冲区处理后才可以输出;
	字符流输出的时候没有关闭输出流,在缓冲区中的数据不会强制性的清空,也就不会输出数据;如遇特殊情况不能关闭字符输出流,可以使用"flush()"方法强制清空缓冲区;
	开发中字符流可以对中文进行有效处理;
=====总结=开发中,如果要处理中文,优先考虑字符流;如果没有中文要处理,建议有线考虑字节流;

==========输入/输出到文件中和内存中的区别?
	输入和输出顺序是反着的;
=====文件=
		输出(OutputStream)=程序->OutputStream->文件;
		输入(InputStream)=程序<-InputStream<-文件;
=====内存=
		输出(InputStream)=程序->InputStream->文件;
		输入(OutputStream)=程序<-OutputStream<-文件;
*/
