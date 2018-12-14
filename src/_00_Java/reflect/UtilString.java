package _00_Java.reflect;

public class UtilString {
	public static String initcap(String str) {
		if (str == null || "".equals(str)) {//判断操作的数据是否有内容
			return str;
		}
		if (str.length() == 1) { //操作的数据只有一位数据
			return str.toUpperCase(); //全部转换为答谢
		} else { //操作的数据超过一位数据
			return str.substring(0,1).toUpperCase() + str.substring(1);
		}
	}
}
