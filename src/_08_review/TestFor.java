package _08_review;
//输出101-200范围内的所有质数
public class TestFor {
	public static void main(String[] args) {
		for (int i = 101;i <= 200;i+=2) {
			boolean isZhiShu = true;
			for(int j = 2;j < i;j++) {
				if(i % j == 0) {
					isZhiShu = false;
					break;
				}
			}
			if(!isZhiShu) {
				continue;
			}
			System.out.println(i);
		}
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public static void main(String[] args) {
		for(int i = 101;i < 200; i += 2) {
			boolean flag = true;
			for(int j = 2;j < i;j++) {
				if(i % j == 0) {
					flag = false;
					break;					
				}
			}
			if(!flag) {
				continue;
			}
				System.out.println("质数:"+i);
			
		}

	}*/
