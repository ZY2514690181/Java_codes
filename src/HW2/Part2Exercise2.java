package HW2;

import java.util.Scanner;

public class Part2Exercise2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number:");
		int N = input.nextInt();
		input.close();
		System.out.println("Number of zeroes in its binary representation:");
		System.out.println(find0inBinary(N));
	}
	
	public static int find0inBinary(int num) {
		// Overall thought: keep dividing the number by 2 and checking the remainder.
		// Earlier calculations suggest the smaller digits in binary representation.
		if (num==0) {
			return 1;
		} // Occurs if you input a 0
		if (num==1) {
			return 0;
		}
		if (num%2==0) {
			return 1+find0inBinary(num/2); // 2 divides the number means an additional 0
		} else {
			return find0inBinary(num/2); // 2 does not divide the number means an additional 1
		}
	}
	// 17 in binary representation should be 10001
	// 17,8,4,2,1    FTTTF, T means even and F means odd
	// 29 in binary representation should be 11101
	// 29,14,7,3,1    FTFFF
	
	// 29=2*14+1, last digit 1, 29 in binary is something followed by 1
	// 14=2*7+0, next last digit 0, 29 in binary is something followed by 01, count for 0 is 1.
	// 7=2*3+1, next last digit 1, 29 in binary is something followed by 101
	// 3=2*1+1, next last digit 1, 29 in binary is something followed by 1101
	// 1 reaches num==1 case, first digit 1, 29 in binary is 11101
	// Count for 0 is 1

}
