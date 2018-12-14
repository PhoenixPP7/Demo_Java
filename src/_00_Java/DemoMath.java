package _00_Java;

import java.math.BigDecimal;

class MyBigDecimal {
	/**
	 * 实现准确位数的四舍五入操作
	 * @param num 要进行四舍五入操作的数字;
	 * @param scale 要保留的小数位;
	 * @return 处理四舍五入后的数据;
	 */
	public static double round(double num,int scale) {
		BigDecimal bigA = new BigDecimal(num);
		BigDecimal bigB = new BigDecimal(1);
		return bigA.divide(bigB, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}

public class DemoMath {
	public static void main(String[] args) {
		System.out.println(MyBigDecimal.round(19.646416484, 2));
		System.out.println(MyBigDecimal.round(15.5, 0));
		System.out.println(MyBigDecimal.round(-15.5, 0));
	}
}

/*
=====[Math]类=[public final class Math extends Object]
	说明=专门进行数学运算的操作类;有final关键字修饰,无法被继承;类中没有普通属性,所有方法都被static关键字修饰,直接通过"类.方法"调用;
	方法=
		四舍五入=[public static long round(double a)];例=Math.round(15.5)=16;Math.round(-15.5)=15;Math.round(-15.51)=16;
			说明=只能保留整数,小数会舍弃;负数的四舍五入操作,操作的数据小时为大于0.5才会进位,小于等于0.5不进位;

=====[Random]类=[public class Random extends Object implements Serializable]
	说明=主要功能是取得随机数的操作类;
	方法=
		产生随机数=[public int nextInt()]

=====[BigInteger]类(大整型数字)=[public class BigInteger extends Number implements Comparable<BigInteger>]
	说明=只能保存整数,不能保存小数;用于数据的值大于了double基本类型的范围;将数字转换为String类型,再计算,详见构造方法;
	方法=
		构造方法=[public BigInteger(String val)];
		...详见API文档;
		
=====[BigDecimal]类(大浮点型数字)=[public class BigDecimal extends Number implements Comparable<BigDecimal>]
	说明=可以保存小数;可以实现准确的四舍五入操作;
	方法=
		构造方法=[public BigDecimal(String val)];接收String类型;
		构造方法=[public BigDecimal(double val)];接收double类型;
		四舍五入=[public BigDecimal divide(BigDecimal divisor,int scale,int roundingMode)]
			说明="BigDecimal divisor"=被除数;
			说明="int scale"=保留的小数位数;
			说明="int roundingMode"=进位模式;使用[BigDecimal]类常量[public static final int ROUND_HALF_UP]
	(重要)例=详见此类程序,是一个实现准确位数的四舍五入操作工具类;
*/