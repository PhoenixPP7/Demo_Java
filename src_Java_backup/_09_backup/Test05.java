package _09_backup;

public class Test05 {

	public static void main(String[] args) {
		int i = -2;
		i = 0x11;
		System.out.println(i+" : ");
		long l = i;
		System.out.println(i+" : "+Integer.toBinaryString(i));
		System.out.println(l+" : "+Long.toBinaryString(l));
		i = 0x000001;
		System.out.println("i = "+i);
	}

}
