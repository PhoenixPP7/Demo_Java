package _00_Java.AJAX;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private String mid;
	private String password;
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMid() {
		return mid;
	}
	public String getPassword() {
		return password;
	}
}
