package _00_Java;

class MathExcption {
	//此方法使用throws关键字定义了异常,调用此方法的程序必须使用"try catch"捕获异常;
	public static int div(int x , int y) throws Exception{
		int result = 0;
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 开始除法运算 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		try {
			result = x / y;		//可能出现异常的语句;
		} catch (Exception e) {
			throw e;		//将异常顺着"throws Exception"抛给调用此方法的程序处理;
		} finally {
			System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ 除法运算结束 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑");	//无论是否产生异常,均执行的语句;
		}
		return result;
	}
}

public class DemoException {
	public static void main(String[] args) {
		try {
			System.out.println(MathExcption.div(10,0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
=====异常的捕获及处理-Exception

=====[Exception]-说明
	所有的异常类都是[Throwable]的子类;
	产生异常语句之后的语句不再执行;
	可利用对象自动向上转型使用Exception接收所有异常,并处理(如打印异常);但建议用不同的异常进行分开处理;
	在编写多个catch捕获异常的时候,捕获范围小的异常应编写在捕获范围大的异常前面,否则出现编译错误;
	关键字=try、catch、finally、throws、throw、assert;
	输出异常信息方法=Exception.printStackTrace();

=====关键字=[throws]
	例=[public int div(int x,int y) throws Exception]
	说明=
		1.此方法产生的异常由该方法的调用处处理;
		2.调用该方法的地方必须使用try...catch捕获并处理异常;或调用该方法的方法继续使用throws关键字往上抛出异常(如=JVM捕获并处理异常,不建议);

=====关键字=[throw]
	说明=方法之中使用"throw"关键字手动抛出一个异常类的实例化对象(这个异常类对象可能是自己实例化或抛出已存在的异常);
	例=catch (Exception e) { throw e; //throw e将异常顺着"throws Exception"抛给调用此方法的程序处理;

=====异常处理标准格式=详见本程序
	说明=使用try、catch、finally、throws、throw关键字;

=====[RuntimeException]=运行时异常
	说明=为方便用户代码的编写,Java专门提供了[RuntimeException]类,编译程序的过程中不会强制要求捕获及处理这个异常类,用户根据自己的需要自行选择是否要捕获及处理,如果没有捕获及处理,将由JVM默认处理;
	例=[Integer]类的[public static int parseInt(String s) throws NumberFormatException]方法,抛出了"NumberFormatException"异常,但调用"parseInt()"方法是可以不使用try...catch强制捕获该异常;
=====常见的RuntimeException异常信息
	数组越界异常=[java.lang.ArrayIndexOutOfBoundsException]
	数字格式异常=[java.lang.NumberFormatException];
	算术异常=[java.lang.ArithmeticException];例="10/0";
	空指针异常=NullPointerException;
	类转换异常=ClassCastException;

=====断言=[assert]关键字---仅了解
	说明=Java中断言指的是程序执行到某行代码处时给定的预期结果;不会影响程序的执行;
	例=int num = 10 ;assert num = 20;

=====自定义异常
	说明=自定义异常类的设计可以选择继承[Exception]或[RuntimeException];使用[Exception]类构造方法=[public Exception(String message)];
		例=throw new Exception("自定义的异常!");catch (Exception e) { e.printStackTrace(); }

=====问题=[Exception]与[RuntimeException]的区别
	Exception是父类,			Exception定义的异常必须被处理;
	RuntimeException是子类;	RuntimeException异常可以选择性处理(如=NumberFormatException属于运行时异常);
	java.lang.Object
		java.lang.Throwable
			java.lang.Exception
				java.lang.RuntimeException
					java.lang.IllegalArgumentException
						java.lang.NumberFormatException
=====问题=[Error和Exception的区别]/[异常处理流程]=详见[03096_异常的捕获及处理（异常处理流程）.jpg]
	[Error]和[Exception]共同父类都是[Throwble];
	[Error]指的是JVM错误;
	[Exception]指的是程序运行中产生的异常,用户可以处理;处理异常指的是Exception及它的子类;
=====问题=[throws]和[throw]的区别
	[throws]=指的是在方法声明上使用,表示此方法调用时必须处理异常;
	[throw]=方法之中使用"throw"关键字手动抛出一个异常类的实例化对象(这个异常类对象可能是自己实例化或抛出已存在的异常);


	
*/
