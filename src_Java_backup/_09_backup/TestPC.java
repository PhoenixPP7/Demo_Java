package _09_backup;

class Province {
	private int pid;
	private String pname;
	private City cities[];
	public Province(int pid,String pname){
		this.pid = pid;
		this.pname = pname;
	}
	public void setPid(int pid){
		this.pid = pid;
	}
	public int getPid(){
		return this.pid;
	}
	public void setPname(String pname){
		this.pname = pname;
	}
	public String getPname(){
		return this.pname;
	}
	public void setCities(City cities[]){
		this.cities = cities;
	}
	public City [] getCities(){
		return this.cities;
	}
	public void getProvinceInfo(){
		System.out.println("ʡ�ݱ�� = " + this.pid + " ; ʡ������ = " + this.pname);
	}
}

class City {
	int cid ;
	String cname;
	private Province province;
	public City(int cid,String cname){
		this.cid = cid;
		this.cname = cname;
	}
	public void setCid(int cid) {
		this.cid = cid ;
	}
	public int getCid(){
		return this.cid;
	}
	public void setCname(String cname){
		this.cname = cname;
	}
	public String getCname(){
		return this.cname;
	}
	public void setProvince(Province province){
		this.province = province;
	}
	public Province getProvince(){
		return this.province;
	}
	public void getCityInfo(){
		System.out.println("���б�� = " + this.cid + " ; �������� = " + this.cname);
	}
}

public class TestPC {
	public static void main(String[] args) {
		Province p1 = new Province(1,"p1");
		City c1 = new City(11,"ca");
		City c2 = new City(12,"cb");
		City c3 = new City(13,"cc");
//		c1.getCityInfo();
//		c2.getCityInfo();
//		c3.getCityInfo();
		c1.setProvince(p1);
//		c2.setProvince(p1);
//		c3.setProvince(p1);
		c1.getProvince().getProvinceInfo();
		p1.setCities(new City [] {c1,c2,c3});
		for (int i = 0 ; i < p1.getCities().length ; i ++){
			p1.getCities()[i].getCityInfo();
		}
//		p1.setPid(1);
//		p1.setPname("pp");
//		p1.setCity(new City{c1,c2,c3});
//		p1.getProvinceInfo();
	}

}
