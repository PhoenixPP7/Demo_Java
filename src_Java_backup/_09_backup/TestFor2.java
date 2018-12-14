package _09_backup;
//输出1-100以内前5个可以被3整除的数
public class TestFor2 {
	public static void main(String[] args) {
		int n = 1 ,m = 0;
		while (n <= 100){
			if(n % 3 == 0) {
				System.out.println(n);
				m++;
			}
			n++;
			if(m == 5) {
				break;
			}
		}
		
/*		int n = 0;
		for(int i = 1;i <= 100;i++) {
			if(i % 3 == 0) {
				System.out.println(i);
				n++;
			}
			if(n == 5) {
				break;
			}
		}*/
	}
}
