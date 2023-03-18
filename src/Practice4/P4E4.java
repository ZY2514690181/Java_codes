package Practice4;

import java.util.Scanner;

public class P4E4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[10];
		Scanner input = new Scanner (System.in);
		for (int i=0; i<10; i++) {
			System.out.println("Enter a number: ");
			nums[i] = input.nextInt();
		}
		System.out.println("Enter the number whose repetition will be displayed: ");
		int num = input.nextInt();
		input.close();
		
		int count = 0;
		for (int i=0; i<10; i++) {
			if (nums[i] == num) {
				count += 1;
			}
		}
		
		System.out.print("The number of appearance of ");
		System.out.print(num);
		System.out.print(" in your array: ");
		System.out.println(count);

	}

}
