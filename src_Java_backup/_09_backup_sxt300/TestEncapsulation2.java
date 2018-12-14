package _09_backup_sxt300;

import _09_backup_sxt300.Human;

public class TestEncapsulation2   {
	public static void main(String[] args) {
		Human  h = new Human();
		h.setAge(16);
		int i = h.getAge();
		System.out.println(i);
		h.setMan(false);
		System.out.println(h.isMan());
		
//		System.out.println(h.getAge());
//		h.name = "���";		//nameΪdefault���ԣ����ܱ���ͬ���������
		
//		h.sayAge();
		
	}
}

class  Girl   extends  Human  {
	void  sayGood(){
		System.out.println(height); 
	}
}