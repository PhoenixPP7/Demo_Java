package _09_backup_sxt300;

public class Test01 {
	public static void main(String[] args) {
//		int[]  arr01 = new int[10] ;			//�����±�[0, length-1]��0,1,2,3,4,5,6,7,8,9 
//		String   arr02[] = new  String[5];
//		arr01[0] = 13;
//		arr01[1] = 15;
//		arr01[2]  = 20;
//		arr01[10] = 100;    // java.lang.ArrayIndexOutOfBoundsException
		
		//ͨ��ѭ����ʼ������
//		for(int i=0;i<arr01.length;i++){
//			 arr01[i] = 10*i;
//		}
//		//ͨ��ѭ����ȡ��������Ԫ�ص�ֵ
//		for(int i=0;i<arr01.length;i++){
//			 System.out.println(arr01[i]);
//		}
		
		User[] arr = new User[5];
		String p = "PP";

		for(int i = 0 ;i < arr.length; i ++) {
			arr[i] = new User();
			arr[i].setId(i);
			arr[i].setName(p);
		}
		
		for(User i:arr) {
			if(i != null)
			System.out.println(i.getId() + "\t" + i.getName());
		}
		
//		for(int i = 0 ;i < arr.length; i ++) {
//			if(arr[i] != null)
//			System.out.println(arr[i].getId() + "\t" + arr[i].getName());
//		}
		
/*		User[]   arr03 = new User[3];
		arr03[0] = new User(1001,"���");
		arr03[1] = new User(1002,"�߶��");
		arr03[2] = new User(1003,"�����");
		
		for(int i=0;i<arr03.length;i++){
			System.out.println(arr03[i].getName());
		}*/
		
	}
}