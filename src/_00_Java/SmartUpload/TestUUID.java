package _00_Java.SmartUpload;

import java.util.UUID;

public class TestUUID {
	public static void main(String[] args) {
	UUID uuid =UUID.randomUUID();//取得一个随机的UUID内容;
	String str = uuid.toString();
	System.out.println(str);
	}

}
