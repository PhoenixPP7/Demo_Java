package _09_backup_io;

import java.io.*;
public class TestFileOutputStream {
  public static void main(String[] args) {
	  int b = 0;
	  FileInputStream in = null;
	  FileOutputStream out = null;
	  try {
	    in = new FileInputStream("D:/2.1-workspace01/test01/bin/package_01_new_io/HelloWorld.java");
	    out = new FileOutputStream("D:/2.1-workspace01/test01/bin/package_01_new_io/HW.java");
	    while((b=in.read())!=-1){
	      out.write(b);
	    }
	    in.close(); 
	    out.close();
	  } catch (FileNotFoundException e2) {
	    System.out.println("�Ҳ���ָ���ļ�"); System.exit(-1);
	  } catch (IOException e1) {
	    System.out.println("�ļ����ƴ���"); System.exit(-1);
	  }
	  System.out.println("�ļ��Ѹ���");
  }
}