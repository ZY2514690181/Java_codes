package Practice4;

import java.util.Scanner;

public class P4E5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[10];
		Scanner input = new Scanner (System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Enter a number: ");
			nums[i] = input.nextInt();
		}
		input.close();
		
		System.out.print("Content of array before the method is implemented: ");
		show(nums);
		System.out.println("");
		replace_prime (nums);
		System.out.print("Content of array after the method is implemented: ");
		show(nums);
		System.out.println("");
		
	}
	
	public static int[] replace_prime (int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (prime(nums[i])) nums[i] = -1;
		}
		return nums;
	}
	
	public static boolean prime (int num) {
		boolean result = true;
		if (num > 2) {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					result = false;
					break;
				}
			}
		} else if (num < 2) {
			result = false;
		}
		return result;
	}
	
	public static void show (int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < (nums.length - 1) ) System.out.print(",");
		}
	}

}
