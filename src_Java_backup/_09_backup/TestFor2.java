package _09_backup;
//���1-100����ǰ5�����Ա�3��������
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
