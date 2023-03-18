package Practice4;

import java.util.Scanner;
public class P4E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] grades = new double[5];
		double sum = 0.0;
		Scanner input = new Scanner (System.in);
		for (int i = 0; i < grades.length; i++) {
			System.out.println("Enter a new grade: ");
			grades[i] = input.nextDouble();
			sum += grades[i];
		}
		input.close();
		double avg = sum / 5;
		System.out.print("average: ");
		System.out.println(avg);

	}

}
