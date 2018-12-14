package _00_Java.reflect;

import java.util.Arrays;

@DemoAnnotation(name="张三",value="hello")
public class Dept {
	private Integer deptno;
	private String dname;
	private Integer loc [];
	private Company company = new Company();
	public Dept() {
	}
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer[] getLoc() {
		return loc;
	}
	public void setLoc(Integer[] loc) {
		this.loc = loc;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc="
				+ Arrays.toString(loc) + ", company=" + company + "]";
	}
	
}
