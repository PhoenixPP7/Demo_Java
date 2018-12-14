package _09_backup_io;

import java.io.*;

public class TestObjectIO {
	public static void main(String args[]) throws Exception {
		T t = new T();
		t.k = 8;
		FileOutputStream fos = new FileOutputStream("D:\\2.1-workspace01\\test01\\src\\package_01_new_io\\testobjectio.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("D:\\2.1-workspace01\\test01\\src\\package_01_new_io\\testobjectio.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T tReaded = (T)ois.readObject();
		System.out.println(tReaded.i + " " + tReaded.j + " " + tReaded.d + " " + tReaded.k);
		
	}
}

class T 
	implements Serializable
{
	int i = 10;
	int j = 9;
	double d = 2.3;
	transient int k = 15;
}