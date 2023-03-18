package HW2;

import java.util.Scanner;

public class Part2Exercise1 {

	public static void main(String[] args) {
		//double[] arr = {23,43,6,3,7,0,3,4.6};
		Scanner input = new Scanner(System.in);
		// Ask the user for an array
		System.out.println("Enter the length of string.");
		int n = input.nextInt();
		double[] arr = new double[n];
		for (int i=0; i<n; i++) {
			System.out.println("Enter an element of your array.");
			arr[i] = input.nextDouble();
		}
		input.close();
		System.out.println("Maximum:");
		System.out.println( findMax(arr, 0, arr.length-1) );
	}
	
	public static double findMax(double[] arr, int start, int end) {
		// basic case
		if (start==end) {
			return arr[start];
		}
		// Split into two parts
		findMax(arr, start, (start+end)/2);
		findMax(arr, (start+end)/2+1, end);
		// return the larger one of two splited parts
		if ( findMax(arr, start, (start+end)/2) > findMax(arr, (start+end)/2+1, end) ) {
			return findMax(arr, start, (start+end)/2);
		} else {
			return findMax(arr, (start+end)/2+1, end);
		}
	}

}
