package Final;

// Use the code provided by professor

public class StackY {
	
	private final int size = 20;
	private double[] st;
	private int top;
	
	public StackY() {
		st = new double[size];
		top = -1;
	}
	
	public void push(double j) {
		st[++top] = j;
	}
	
	public double pop() {
		return st[top--];
	}
	
	public double peek() {
		return st[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
}
