package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the lower bound: ");
		int lower = input.nextInt();
		System.out.print("Enter the upper bound: ");
		int upper = input.nextInt();
		input.close();
		System.out.print("random integer generated: ");
		System.out.println(integer_in_range(lower,upper)); // call method

	} // main
	
	public static int integer_in_range(int lower, int upper) {
		// Assume that lower is not greater than upper
		return (int)(lower + Math.random() * (upper-lower+1));
		// Assume both upper and lower can be taken
	} // method

} // Ex7
