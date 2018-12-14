package _00_Java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDate {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String str = sdf.format(date);	//将Date对象类型转换为String类型;
		System.out.println(str);
		
		String str2 = "2018-11-27 12:59:30.222";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date2 = sdf2.parse(str2);	//将String转换为Date对象类型数据;
		System.out.println(date2);
	}
}

/*
=====[Date]=[java.util.Date]=
	说明=long基本数据类型可以描述日期时间数据,
	方法=
		无参构造方法=[public Date()]
		有参构造方法=[public Date(long date)];接收long类型数据,转换为Date对象;
		转换为long数据类型方法=[public long getTime()]
		例=
			使用[System]类[public static long currentTimeMillis()]方法,取得当前日期时间,以long类型返回;
			使用[Date]类构造方法[Date(long date)],将取得的long类型数据传入;
			使用[Date]类[getTime()]取得时间数据;
=====[SimpleDateFormat]=[java.text.SimpleDateFormat]=(重要)
	说明=[java.text]包是一个专门实现国际化程序的开发包;[SimpleDateFormat]是一个专门处理格式化日期的工具类;
		可以将[Date]类的实例化对象转换为String类型的形式显示;
	方法=
		构造方法=[SimpleDateFormat(String pattern)];参数"String pattern"中定义的常用转换格式的单位=年(yyyy)、月(MM)、日(dd)、时(HH)、分(mm)、秒(ss)、毫秒(SSS);
		将[Date]对象转换为String=使用[java.text.DateFormat]类的[public final String format(Date date)]方法
		将String转换为[Date]对象=使用[java.text.DateFormat]类的[public Date parse(String source) throws ParseException]方法;
	例=将日期格式化显示([Date]类型数据转换为String类型数据),详见本程序;
	例=将日期格式化显示(String类型数据转换为[Date]类型数据),详见本程序;

=====[Calendar]=[public abstract class Calendar extends Object implements Serializable, Cloneable, Comparable<Calendar>]
	说明=[Calender]类主要用于进行一些简单的日期计算;是一个抽象类;应该依靠子类或本类的[getInstance]方法取得实例化对象;
	方法=取得本类的对象=[public static Calendar getInstance()];
	例=详见截图;
	总结=使用此类进行日期计算要较[Date]类容易;因为[Date]类进行日期计算需要使用long类型;

=====总结
	1.[Date]类和[SimpleDateFormat]类这两个类往往一起使用;
	2.数据库的日期类型使用[java.util.Date]对象类型表示;
	3.代码模型=[SimpleDateFormat]类实现String和[Date]对象类型之间的互相转换;
*/