package _09_backup_Socket.TCP;
/*
TCP��Server��:
��һ��:newһ��ServerSocket������ĳ�˿�(����˿�ѡ��:1024~65530);
�ڶ���:����accept()����,��������ĳ������;
������:���յ�ĳ������֮��,ͨ��InputXXXXX��OutputXXXXX��ʼͨ��;
���Ĳ�:�ر�Socket��InputXXXXX��OutputXXXXX;
*/
import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(6666);
		while(true) {
			Socket s = ss.accept();
			System.out.println("Server : a client connect!");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
		
	}
}