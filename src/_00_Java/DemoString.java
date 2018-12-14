package _00_Java;

class StringTest {
	
	
}

public class DemoString {
	public static void main(String[] args) {
		String str = "张三:22|李四:33|王五:44|孙六:66:男";
		String [] split1 = str.split("\\|");
		for (int x = 0 ; x < split1.length ; x ++) {
			String [] split2 = split1[x].split(":");
			for (int y = 0 ; y < split2.length ; y ++) {
				System.out.println("split [" + x + " ] [ " + y + " ] = " + split2[y] );
			}
		}
	}

}



/*
=====[String]类
=====char和[String]=方法
	构造方法=将字符数组变为String类对象=[public String(char[] value)]
	构造方法=将部分字符数组变为String类对象=[public String(char[] value,int offset,int count)]
	返回制定索引对应的字符数据=[public char charAt(int index)]
	将字符串以字符数组的形式返回=[public char[] toCharArray()]
=====byte和[String]=方法
	构造方法=将全部字节数组变为字符串=[public String(byte[] bytes)]
	构造方法=将部分字节数组变为字符串=[public String(byte[] bytes,int offset,int length)]
	*将字符串变为字节数组=[public byte[] getBytes()]
	进行编码转换=[public byte[] getBytes(String charsetName) throws UnsupportedEncodingException]
=====字符串比较=方法
	进行相等判断,区分大小写=[public boolean equals(String anObject)]
	进行相等判断,不区分大小写=[public boolean equalsIgnoreCase(String anotherString)]
	判断两个字符串的大小(按字符编码比较)=[public int compareTo(String anotherString)];返回值"等于0"表示相等;"大于0"表示大于;"小于0"表示小于;
=====字符串查找=方法
	判断指定的内容是否存在=[public boolean contains(String s)]
	由前向后查找制定字符串的位置,如果查找到了返回(首次出现)位置索引,如果找不到返回"-1"=[public int indexOf(String str)]
	由指定位置从前往后查找指定字符串的位置,找不到返回"-1"=[public int indexOf(String str,int fromIndex)]
	由后向前查找指定字符串的问题,找不到返回"-1"=[public int lastIndexOf(String str)]
	由指定位置从后向前查找字符串的文职,找不到返回"-1"=[public int lastIndexOf(String str,int fromIndex)]
	判断是否以指定的字符串开头=[public boolean startsWith(String prefix)]
	从指定位置开始判断是否以指定的字符串开头=[public boolean startsWith(String prefix,int toffset)]
	判断是否以制定的字符串结尾=[public boolean endsWith(String suffix)]
=====字符串替换=方法
	使用新的字符串替换掉全部旧的字符串=[public String replaceAll(String regex,String replacement)]
	替换掉首个满足条件的字符串=[public String replaceFirst(String regex,String replacement)]
=====字符串截取=方法
	从指定索引开始截取字符串,截取到结尾=[public String substring(int beginIndex)]
	从指定索引开始截取字符串,截取到指定结束索引=[public String substring(int beginIndex,int endIndex)]
=====字符串拆分=方法
	按照指定的字符串进行全部拆分=[public String[] split(String regex)]
	按照指定的字符串进行部分拆分,数组长度由limit决定=[public String[] split(String regex,int limit)]
=====字符串=其他方法
	字符串连接,与"+"类似=[public String concat(String str)]
	将字符串转换为小写=[public String toLowerCase()]
	将字符串转换为大写=[public String toUpperCase()]
	去掉字符串中首尾的空格,字符串中间的空格保留=[pubic String trim()]
	取得字符串长度=[public int length()]
	数据入池=[public String intern()]
	判断字符串是否为空"",不是指null=[public boolean isEmpty()]
=====[String]类总结
	[String]类对象两种实例化方式=
		直接赋值=只开辟一块堆内存空间,可以自动入池;
		构造方法=开辟两块堆内存空间,不会自动入池,需使用intern()手工入池;
	任何一个字符串都是[String]类的匿名对象;
	字符串一旦声明不可改变,可以改变的是[String]类对象的引用;
*/

/*
=====[StringBuffer]和[StringBuilder]
	说明=[StringBuffer]类和[StringBuilder]类必须使用关键字new实例化对象;内容可以进行修改;
		此两个类在定义上非常相似;构造方法和普通方法几乎一样;
		区别在于[StringBuffer]有同步要求;[StringBuilder]没有同步要求;

=====[StringBuffer]类和[String]类,有关系的方法
	[String]类对象转换为[StringBuffer]类对象的方法=
		1.使用[StringBuffer]类的[append()]方法=[public StringBuffer append(String str)];
		2.使用[StringBuffer]类的构造方法接收[String]类对象=[public StringBuffer(String str)];
	[StringBuffer]类对象转换为[String]类对象的方法=
		1.使用[toString()]方法=[buf.toString()];
		2.使用[String]类的构造方法接收[StringBuffer]类对象=[public String(StringBuffer buffer)];
	[StringBuffer]类和[String]类对象比较方法=
		使用[String]类的方法=[public boolean contentEquals(StringBuffer sb)];
=====[StringBuffer]类方法
	字符串反转方法=[public StringBuffer reverse()];
	指定索引位置插入数据=[public StringBuffer insert(int offset,数据类型 变量)]
	删除部分数据=[public StringBuffer delete(int start,int end)];
*/

/*
=====问题=[String]、[StringBuffer]、[StringBuilder]区别=
	[String]类可以通过直接赋值实例化;[String]的内容一旦声明不可改变;
	[StringBuffer]类必须使用关键字new实例化对象;内容可以改变;方法是同步方法,属于安全的线程操作;
	[StringBuilder]类必须使用关键字new实例化对象;内容可以改变;方法是异步方法,属于非线程安全的操作;
	都是[CharSequence]接口的子类;可通过向上转型转换为[CharSequence]对象;例=CharSequence seq = "String";
*/