package _09_backup_new;

import java.net.Socket;
import java.util.Scanner;

public class HelloClient {

	public static void main(String[] args) throws Exception {
		Socket client = new Socket("localhost", 9999);
		Scanner scan = new Scanner(client.getInputStream());
		scan.useDelimiter("\n");
		if (scan.hasNext()) {
			System.out.println("Client : ��Ӧ��� = " + scan.next());
		}
		scan.close();
		client.close();

	}

}
