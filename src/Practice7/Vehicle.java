package Practice7;

public class Vehicle {
	
	protected String name;
	protected int year;
	
	public Vehicle(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
	public String getname() {
		return name;
	}
	
	public int getyear() {
		return year;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setyear(int year) {
		this.year = year;
	}
	
	public void printinfo() {
		System.out.println("Name: "+name);
		System.out.println("Year: "+year);
	}
	
	public void sell(int year) {
		this.year = year;
		System.out.println("Successful sale");
	}

}
