

import java.util.Scanner;
public class P3E3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter num1: ");
		int num1 = input.nextInt();
		System.out.println("Enter num2: ");
		int num2 = input.nextInt();
		input.close();
		System.out.println("Largest num: ");
		System.out.println(max (num1, num2));
	}
	public static int max(int num1, int num2) {
		int result;
		if (num1 > num2)
			result = num1;
		else
			result = num2;
		return result;
	}
}
