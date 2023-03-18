package Practice7;

public class Car extends Vehicle {
	
	private String type;
	private String color;
	
	public Car (String name, int year, String type, String color) {
		super(name,year);
		this.type = type;
		this.color = color;
	}
	
	public String gettype() {
		return type;
	}
	
	public String getcolor() {
		return color;
	}
	
	public void settype(String type) {
		this.type = type;
	}
	
	public void setcolor(String color) {
		this.color = color;
	}
	
	public void sell(int year, String color) {
		this.year = year;
		this.color = color;
		System.out.println("Successful sale");
	}
	
	public void printinfo() {
		System.out.println("Name: "+name);
		System.out.println("Year: "+year);
		System.out.println("Type: "+type);
		System.out.println("Color: "+color);
	}

}
