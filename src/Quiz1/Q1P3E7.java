package Quiz1;

import java.util.Scanner;

public class Q1P3E7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println ("Enter the number: ");
		int num1 = input.nextInt();
		input.close();
		String num2 = Integer.toString(num1);
		System.out.println("leading digit: " + num2.charAt(0));

	}

}

//Consult: https://www.geeksforgeeks.org/different-ways-for-integer-to-string-conversions-in-java/