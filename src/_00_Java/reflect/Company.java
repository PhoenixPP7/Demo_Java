package _00_Java.reflect;

import java.util.Arrays;
import java.util.Date;

@DemoAnnotation(name="张三",value="hello")
public class Company {
	private Integer title;
	private Date credate;
	private double p [];
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	public double[] getP() {
		return p;
	}
	public void setP(double[] p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return "Company [title=" + title + ", credate=" + credate + ", p="
				+ Arrays.toString(p) + "]";
	}

	
}
