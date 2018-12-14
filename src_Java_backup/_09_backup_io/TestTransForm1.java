package _09_backup_io;

import java.io.*;
public class TestTransForm1 {
  public static void main(String[] args) {
    try {
      OutputStreamWriter osw = new OutputStreamWriter(
           new FileOutputStream("D:\\2.1-workspace01\\test01\\bin\\package_01_new_io\\char.txt"));
      osw.write("mircosoftibmsunapplehp");
      System.out.println(osw.getEncoding());
      osw.close();
      osw = new OutputStreamWriter(
      								new FileOutputStream("D:\\\\2.1-workspace01\\\\test01\\\\bin\\\\package_01_new_io\\\\char.txt", true),
      								"ISO8859_1"); // latin-1
      osw.write("mircosoftibmsunapplehp");
      System.out.println(osw.getEncoding());
      osw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}