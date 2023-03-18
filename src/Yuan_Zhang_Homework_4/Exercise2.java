package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println("Enter an integer");
		int num1 = input.nextInt();
		System.out.println("Enter an integer");
		int num2 = input.nextInt();
		input.close();
		System.out.print("Last digit: ");
		System.out.println(last_digit(num1 + num2));

	} // end of main
	
	public static int last_digit (int num) {
		if (num < 0) {
			num = 0 - num;
		} // If input is negative, remainder causes trouble
		return num % 10; // give the last digit
	} // end of method

} // end of Exercise2