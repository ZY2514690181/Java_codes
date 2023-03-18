package Yuan_Zhang_Homework_3;

import java.util.Scanner;

public class Exercise4B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner (System.in);
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		input.close();
		// Assume a positive value is entered
		
		// find out the number of digits in binary first
		int digitnum = 0;
		for (int i = 0; num >= Math.pow(2, i); i++) {
			digitnum += 1;
		}
		
		// do long division with remainders
		String numbinary = "";
		for (int i = 1; i < digitnum; i++) {
			numbinary = Integer.toString(num % 2) + numbinary;
			num = num / 2;
		}
		numbinary = "1" + numbinary;
		
		System.out.println("To binary: ");
		System.out.println(numbinary);

	}

}

// To solve integer to string, cite below
// Consult https://www.geeksforgeeks.org/different-ways-for-integer-to-string-conversions-in-java/