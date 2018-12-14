package _09_backup_Socket.TCP;
/*
TCP��Client��:
��һ��:newһ��Socket��ͨ��IP��ַ�Ͷ˿����ӵ��������˶�ӦSocket;
�ڶ���:����֮��,ͨ��InputXXXXX��OutputXXXXX��ʼͨ��;
������:�ر�Socket��InputXXXXX��OutputXXXXX;
*/
import java.net.*;
import java.io.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread.sleep(3000);
		dos.writeUTF("Client : hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
}