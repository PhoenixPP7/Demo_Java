package _00_Java;

public class DemoComparable {
	public static void main(String[] args) {
	}
}

/*
==========比较器
=====比较器=[java.lang Interface Comparable<T>](核心)
		说明=此接口定了比较规则;
		方法=[public int compareTo(T o)]
			说明=[String]类就是[Comparable]接口的子类,[compareTo()]方法就是[Comparable]接口的比较操作的功能;此方法会被[Arrays]类[sort()]方法自动调用;
				实现[compareTo()]方法进行对象比较,建议返回三类数据=1(大于)、0(等于)、-1(小于);
	
=====比较器=[java.util.Arrays]类(了解)
		方法=
		数组排序=[public static void sort(数据类型 a)];例=[public static void sort(int[] a)]
		对象数组排序=[public static void sort(Object[] a)];说明=要排序的对象数组需实现[java.lang Interface Comparable<T>]接口;
		二分查找法=[public static int binarySearch(数据类型[] a,数据类型 key)];例=[public static int binarySearch(int[] a,int key)]
			二分查找法的前提=要查找的数据已完成排序;
		数组比较=[public static boolean equals(数据类型[] a,数据类型[] a2)];例=[public static boolean equals(int[] a,int[] a2)]
			数组相同的条件=数组内容及顺序完全相同;
		数组填充=[public static void fill(数据类型[] a,数据类型 val)];例=[public static void fill(int[] a,int val)]
		数组转换为字符串输出=[public static String toString(数据类型[] a)];例=[public static String toString(int[] a)]
	
=====数据结构-二叉树=BinaryTree(了解)
		说明=选择第一个数据作为根节点,比根节点小的放在根节点的左子树(左节点),否则放在右子树(右节点),以此类推比较并存放剩余的数据,取得数据的时候按照中序遍历的方式去除(左-中-右);
			数据结构中Node核心功能是保存真实数据及配置节点关系;
			
=====比较器=[java.util Interface Comparator<T>](了解)
		说明=用于某个类在设计之初未考虑对象数组排序功能、未实现[Comparable]的情况下,之后的设计又需要增加对象数组比较功能时,可使用[Comparator]接口实现;
			使用此接口实现某个类的比较功能,需定义一个具有比较功能的类实现此接口;
		方法=
			对象比较=[int compare(T o1,T o2)]
			对象数组排序=使用[Arrays]类中被重载的[public static <T> void sort(T[] a,Comparator<? super T> c)]方法排序;
	
=====总结
	实际工作中使用[Comparable]接口;
	
=====问题=Comparable和Comparator的区别?
	如果对象数组要进行排序,那么必须设置排序规则,可以使用[Comparable]或[Comparator]接口;
	[Comparable]接口是在定义一个类的同时实现的接口,这样此类的对象数组就可以进行排序,使用此接口的[compareTo()]方法;
	[Comparator]接口时专门定义一个指定类的比较规则,属于后补的比较操作,使用此接口的[compare()]方法;
*/
