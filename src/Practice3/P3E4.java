package Practice3;

import java.util.Scanner;
public class P3E4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter num1: ");
		int num1 = input.nextInt();
		System.out.println("Enter num2: ");
		int num2 = input.nextInt();
		System.out.println("Enter num3: ");
		int num3 = input.nextInt();
		input.close();
		System.out.println("Largest num: ");
		int hold = max(num1, num2);
		System.out.println(max (hold, num3));
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
