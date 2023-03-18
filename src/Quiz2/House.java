package Quiz2;

public class House {
	
	private int id;
	private double price;
	private boolean status; // true if available for sell, false if not
	// assume the user knows what true and false mean
	
	public House (int id, double price, boolean status) {
		this.id = id;
		this.price = price;
		this.status = status;
	}
	
	public int getid() {
		return id;
	}
	
	public double getprice() {
		return price;
	}
	
	public boolean getstatus() {
		return status;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public void setprice(double price) {
		this.price = price;
	}
	
	public void setstatus(boolean status) {
		this.status = status;
	}
	
	public void printAll() {
		System.out.println("ID: "+id+", Price: "+price+", status: "+status);
	}

}
