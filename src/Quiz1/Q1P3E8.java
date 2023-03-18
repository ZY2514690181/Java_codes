package Quiz1;

import java.util.Scanner;
public class Q1P3E8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("X ");
		int x = input.nextInt();
		System.out.println("Y ");
		int y = input.nextInt();
		input.close();
		System.out.print("Sum of x and y: ");
		System.out.println(sum(x,y));
		System.out.print("Subtraction of x and y: ");
		System.out.println(subtraction(x,y));
		System.out.print("Division of x and y: ");//integer division
		System.out.println(division(x,y));
		System.out.print("Multiplication of x and y: ");
		System.out.println(multiplication(x,y));
		System.out.print("Remainder of x and y: ");
		System.out.println(remainder(x,y));

	}
	
	public static int sum(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	public static int subtraction(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
	public static int division(int num1, int num2) {
		int result = num1 / num2;
		return result;
	}
	public static int multiplication(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}
	public static int remainder(int num1, int num2) {
		int result = num1 % num2;
		return result;
	}
	
}
//Explain: The calculation step could be replaced by methods.
//For each one type of calculation, two int values are taken and manipulated.
//Result is returned to give the answer.