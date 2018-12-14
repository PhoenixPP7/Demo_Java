package _09_backup_new;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		System.out.println("�ȴ�ͻ�������......");
		Socket client = server.accept();
		PrintStream out = new PrintStream(client.getOutputStream());
		out.println("Server : Hello !");
		out.close();
		client.close();
		server.close();

	}

}
