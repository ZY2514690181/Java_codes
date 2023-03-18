package ExceptionsPractice;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Student {
	
	Scanner input = new Scanner(System.in);
	
	private String name;
	private int age;
	private String motivation;
	
	Student(){
		
		while (true) {
			try {
				System.out.println("Enter age: ");
				int age0 = input.nextInt();
				setAge(age0);
				break;
			} // end of try
			catch (InputMismatchException e) {
				System.out.println("Input needs to be an integer.");
				input.nextLine();
			} // end of catch
		} // end of while loop
		
		while (true) {
			try {
				setName();
				break;
			} // end of try
			catch (InputMismatchException e) {
				System.out.println("You should not see this line.");
			} // end of catch
			finally {
				System.out.println("This is for finally.");
			}
		} // end of while loop
		
		input.close();
		
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setName(){
		input.nextLine();
		System.out.println("Enter name: ");
		name = input.nextLine();
	}	

}
