package _09_backup_sxt300;

public class TestEquals {
	public static void main(String[] args) {
		Object obj;
		String str;
		
		User   u1 = new User(1000,"���","123456");
		User   u2 = new User(1000,"��ϣϣ","123456");
		
		System.out.println("u1 = " + u1);//u1 = package_01_sxt300.User@407
		System.out.println("u2 = " + u2);//u2 = package_01_sxt300.User@407
		System.out.println(u1==u2);//false
		System.out.println(u1.equals(u2)); //true
		
		String  str1 = new String("sxt");
		String  str2 = new String("sxt");
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println(str1==str2);  //false
		System.out.println(str1.equals(str2));  //true
		
	}
	
	
}

/*class  User  {
	int id;
	String name;
	String pwd;

	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public User() {
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		return result;
//	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (this.id != other.id)
//		if (id != obj.id)
			return false;
		return true;
	}
}*/