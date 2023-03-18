package Yuan_Zhang_Homework_3;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// This program will have errors or inaccurate results if negative integers or 0 are entered
		// Assume the input includes only the positive numbers
		
		Scanner input = new Scanner (System.in);
		System.out.print("Enter an integer: ");
		int base = input.nextInt();
		System.out.print("What power do you want ");
		System.out.print(base);
		System.out.print(" to be raised to? ");
		int index = input.nextInt();
		input.close();
		int result = 1;
		for (int i = 1; i <= index; i++) {
			result *= base;
		}
		for (int i = 1; i <= index; i++) {
			System.out.print(base);
			if (i < index) System.out.print(" x ");
		}
		System.out.print(" = ");
		System.out.println(result);

	}

}
