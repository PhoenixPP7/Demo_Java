package _09_backup;

public class Test03 {

	public static void main(String[] args) {
		System.out.println(Byte.MIN_VALUE+"~"+Byte.MAX_VALUE);
		String num="108";
		System.out.println(Byte.parseByte(num)+10);
		System.out.println(Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		System.out.println(Integer.parseInt(num)+20);
		System.out.println("33的十六进制="+Integer.toHexString(33)+";   16的二进制="+Integer.toBinaryString(16));

	}

}
