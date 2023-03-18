package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a number: ");
		int num1 = input.nextInt();
		System.out.print("Enter a number: ");
		int num2 = input.nextInt();
		input.close();
		check(num1,num2); // call the method

	}
	
	public static void check(int num1, int num2) {
		boolean result = false; // false means not a multiple
		if (num1 == 0 && num2 == 0) {
			result = true; // 0 is a multiple of 0
		// if num1 is 0 and num2 is not, false
		} else if (num1!= 0 && num2%num1 == 0) {
			result = true; // divisible hence true
		}
		// not divisible hence false
		if (result) {
			System.out.println(num2+" is a multiple of "+num1);
		} else {
			System.out.println(num2+" is not a multiple of "+num1);
		}
	}

}
