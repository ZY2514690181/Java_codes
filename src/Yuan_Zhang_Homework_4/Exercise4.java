package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		input.close();
		System.out.print("Result: ");
		System.out.println(change(num)); // call the method

	}
	
	public static int change(int num) {
		if (num < 0) {
			num = 0 - num;
			// If input is negative, remainder causes trouble
		}
		return (num+1)%2;
		// Normally num%2 returns 0 for the even and 1 for the odd.
		// num+1 helps flip the results
	} // method

} // Ex4