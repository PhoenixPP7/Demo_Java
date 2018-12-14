package _09_backup_sxt300;

public  class  Human {
	private  int age ;
	boolean man;
//	String  name;			//���Ա���������������
//	protected   int  height;   

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
//		if(age < 0 || age > 150) 
//			System.out.println("��������ȷ������");
		if(age >= 0 && age <= 150)
		this.age = age;
		else
			System.out.println("��������ȷ������");
	}

	public boolean isMan() {
		return man;
	}

	public void setMan(boolean man) {
		this.man = man;
	}
	
	
//	public  void   sayAge(){
//		System.out.println(age);
//	}
//
//
//	public int getAge() {
//		return age;
//	}
//	public int geAge() {
//		return age;
//	}
	
	

	
	
}