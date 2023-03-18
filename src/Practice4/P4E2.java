package Practice4;

import java.util.Scanner;
public class P4E2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] grades = new double[5];
		Scanner input = new Scanner (System.in);
		for (int i = 0; i < grades.length; i++) {
			System.out.println("Enter a new grade: ");
			grades[i] = input.nextDouble();
		}
		input.close();
		System.out.print("average: ");
		System.out.println(avg(grades));

	}
	
	public static double avg(double[] nums) {
		double sum = 0.0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return (sum / nums.length);
	}

}
