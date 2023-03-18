package Quiz1;

import java.util.Scanner;

public class Q1P1E5 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Calculate the area of a circle.");
		System.out.println("Enter the radius: ");
		double r = input.nextDouble();
		input.close();
		double area = Math.PI * r * r;
		System.out.print("area: ");
		System.out.println(area);
	}
}
