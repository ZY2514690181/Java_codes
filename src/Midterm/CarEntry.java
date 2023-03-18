package Midterm;

public class CarEntry {
	
	// member variables
	
	private String name;
	private double price;
	
	// constructor
	
	public CarEntry(String n, double p) {
		name = n;
		price = p;
	}
	
	// getters and setters
	
	public String getname() {
		return name;
	}
	
	public double getprice() {
		return price;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setprice(double price) {
		this.price = price;
	}
	
	public void printcar() {
		System.out.println("Car name: "+name+"  Car price: "+price);
	}

}
