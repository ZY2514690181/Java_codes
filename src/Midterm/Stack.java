package Midterm;

public class Stack {
	
	String[] str;
	
	public Stack(String[] str) {
		this.str = str;
	}
	
	public boolean isEmpty() {
		if (str.length == 0) return true;
		return false;
	}
	
	public void push(String word) {
		String[] str_new = new String[str.length+1];
		for (int i=0; i<str.length; i++) {
			str_new[i] = str[i];
		}
		str_new[str.length] = word;
		str = str_new;
	}
	
	public String pop() {
		String[] str_new = new String[str.length-1];
		for (int i=0; i<str.length-1; i++) {
			str_new[i] = str[i+1];
		}
		String temp = str[0];
		str = str_new;
		return temp;
	}
	
}
