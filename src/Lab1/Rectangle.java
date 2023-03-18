package Lab1;

public class Rectangle {
	
	private int length;
	private int width;
	
	public Rectangle() {
		length = 1;
		width = 1;
	}
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;		
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getArea() {
		for (int i = 1; i<=10; i++) {
			System.out.println("The area is " + length * width);
		}
		return length * width;
	}
	
	public boolean checkSquare() {
		if (length == width) {
			return true;
		} else {
			return false;
		}
	}
	
}

// Assume the length and width are positive.