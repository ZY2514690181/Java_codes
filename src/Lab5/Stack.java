package Lab5;

import java.io.Serializable;

public class Stack<T> implements Comparable<Stack<T>>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	T[] stack;
	int top;
	
	transient int admin;
	
	public Stack(int n) {
		stack = (T[]) new Object[n];
		top = -1;
		admin = 42;
	}
	
	public Stack() {
		this(5);
	}
	
	public void push(T n) {
		if(top == 4) {
			System.out.println("Stack Overflow");
			return;
		}
		
		stack[++top] = n;
		System.out.println("Pushed " + n);
	}
	
	public T pop() {
		if(top == -1)
			System.out.println("Stack Underflow");
		
		return stack[top--];
	}
	
	public void display() {
		for(int i = 0; i <= top; i++)
			System.out.print(stack[i] + " ");
		
		System.out.println();
	}
	
	public void display(int start, int end) {
		if(start > top)
			return;
		if(end > top)
			end = top;
		for(int i = start; i <= end; i++)
			System.out.print(stack[i] + " ");
		
		System.out.println();
	}
	
	public void search(T n) {
		for(int i = 0; i <= top; i++)
			if(stack[i] == n) {
				System.out.println("Found at " + i);
				return;
			}
		
		System.out.println("Not found");
	}

	@Override
	public int compareTo(Stack o) {
		if(this.top < o.top)
			return -1;
		else if(this.top == o.top)
			return 0;
		else
			return 1;
	}
}
