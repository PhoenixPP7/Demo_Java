package _09_backup_io;

import java.util.*; 
import java.io.*;
public class TestPrintStream3 {
  public static void main(String[] args) {
    String s = null;
    BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in));
    try {
      FileWriter fw = new FileWriter
                           ("D:\\2.1-workspace01\\test01\\src\\package_01_new_io\\logfile.log", true); //Log4J
      PrintWriter log = new PrintWriter(fw);
      while ((s = br.readLine())!=null) {
        if(s.equalsIgnoreCase("exit")) break;
        System.out.println(s.toUpperCase());
        log.println("-----");
        log.println(s.toUpperCase()); 
        log.flush();
      }
      log.println("==="+new Date()+"==="); 
      log.flush();
      log.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}