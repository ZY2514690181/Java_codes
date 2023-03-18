package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter the radius: ");
		double radius = input.nextDouble();
		input.close();
		System.out.print("Area of the circle: ");
		System.out.println(area(radius)); // call the method

	} // main
	
	public static double area(double radius) {
		if (radius <= 0) {
			System.out.println("Radius is not positive. The results by formula will be displayed, but it is meaningless.");
			// Clarify that the result is only valid if radius is positive
		}
		return Math.PI * radius * radius;
	} // method

} // Ex3