package _09_backup;

import com.sun.glass.ui.CommonDialogs.Type;

public class TypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=(byte)1233;
		System.out.println("i = "+i);
		byte t =(int)12;
		System.out.println("t = "+t);
		float f = (float)4.56;
		System.out.println("f = "+f);
		float f1 = 4.56f;
		System.out.println("f1 = "+f1);
		double d = 7.89e300;
		float f2 =(float)d;
		System.out.println("f2 = "+f2);
		byte b1 = 66;
		byte b2 = 99;
		byte b3 = (byte) (b1 + b2);
		System.out.println("b3 = "+b3);
		double d3 = 2.2;
		double d4 = d3 - 2.1;
		System.out.println("d4 = "+d4);
		char c1 = '\n';
		System.out.println("c1 = "+c1+" ."+'\n'+"..");
				
				

	}

}
