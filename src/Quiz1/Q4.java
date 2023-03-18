package Quiz1;

import java.util.Scanner;
public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println("Enter the value of a: ");
		double a = input.nextDouble();
		System.out.println("Enter the value of b: ");
		double b = input.nextDouble();
		input.close();
		
		double hold = a;
		a = b;
		b = hold;
		
		System.out.println("a: ");
		System.out.println(a);
		System.out.println("b: ");
		System.out.println(b);

	}

}

//Consult: https://www.geeksforgeeks.org/returning-multiple-values-in-java/