package _09_backup;

public class TestIfElse {
//����0-10�Ľ׳�.
/*	public static void main(String[] args) {
		long result = 0;
		long f = 1;
		for (int i=1;i <=10;i++) {
			f = f * i;
			result = result + f;
			System.out.print("i = "+i+"; result = "+result+";\n");
		}
		System.out.println("\nresult = "+result);
	}*/
	public static void main(String[] args) {
		//����1+3+5+...99��ֵ
		int f = 0;
		for(int i=1;i<=99;i=i+2) {
			f = f + i;
			System.out.println("i = "+i+";f = "+f);
		}
		System.out.println("f = "+ f);
	}
}
