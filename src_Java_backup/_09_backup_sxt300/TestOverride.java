package _09_backup_sxt300;

/**
 * ������д(override)/����
 * @author ���
 *
 */
public class TestOverride {
		public static void main(String[] args) {
			Horse   h   =  new Horse();
			h.run();
		}
}


class  Vehicle {
	public  void  run(){
		System.out.println("��....");
	}
	
	public   void stop(){
		System.out.println("ֹͣ��");
	}
	
//	public  Person   whoIsPsg(){
//		return  new Person();
//	}
	
}

class    Horse   extends  Vehicle {
	public  void  run(){
		System.out.println("���㷭�ɣ��N�N�ġ�����");
	}
	
//	public  Student   whoIsPsg(){//����ֵ����С�ڵ��ڸ��������
//		return  new Student();
//	}
	
}


