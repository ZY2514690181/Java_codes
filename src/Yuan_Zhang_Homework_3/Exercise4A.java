package Yuan_Zhang_Homework_3;

import java.util.Scanner;

public class Exercise4A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner (System.in);
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		input.close();
		System.out.println("To binary: ");
		System.out.println(Integer.toBinaryString(num));

	}

}

// Consult: https://www.geeksforgeeks.org/java-lang-integer-tobinarystring-method/