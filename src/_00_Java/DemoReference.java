package _00_Java;

class People {
	private String name;
	private Car car;
	private People son;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public People getSon() {
		return son;
	}
	public void setSon(People son) {
		this.son = son;
	}
	public String peopleInfo() {
		return "name = " + this.name + " ; car = " + this.car.getBrand() + " ; son = " + this.son.getName() ;
	}
}

class Car {
	private String brand;
	private People owner;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public People getOwner() {
		return owner;
	}
	public void setOwner(People owner) {
		this.owner = owner;
	}
	public String carInfo(){
		return "brand = " + this.brand + " ; owner = " + this.owner.getName() ;
	}
}

public class DemoReference {
	public static void main(String[] args) {
		People father = new People();
		Car toyota = new Car();
		Car toy = new Car();
		People son = new People();
		People sonson = new People();
		
		father.setName("PP");
		father.setCar(toyota);
		father.setSon(son);
		
		toyota.setBrand("tyo");
		toyota.setOwner(father);
		toy.setBrand("lego");
		
		son.setName("TT");
		son.setCar(toy);
		son.setSon(sonson);
		
		sonson.setName("sonson");

		System.out.println(father.peopleInfo());
		System.out.println(father.getSon().peopleInfo());
	}

}
