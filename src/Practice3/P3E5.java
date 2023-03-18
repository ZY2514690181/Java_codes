package Practice3;

import java.util.Scanner;
public class P3E5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter num: ");
		int num = input.nextInt();
		input.close();
		System.out.println("Absolute value: ");
		System.out.println(absolute_value (num));
	}
	public static int absolute_value (int num) {
		int result;
		if (num > 0)
			result = num;
		else
			result = 0-num;
		return result;
	}
}
