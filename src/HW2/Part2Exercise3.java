package HW2;

import java.util.Scanner;

public class Part2Exercise3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word:");
		String str = input.nextLine();
		input.close();
		if (checkPalindrome(str, 0, str.length()-1)) {
			System.out.println("It is a palindrome.");
		} else {
			System.out.println("It is not a palindrome.");
		}
	}
	
	public static boolean checkPalindrome(String str, int start, int end) {
		// basic case, > means even number of char, == means odd number of char
		if (start>=end) {
			return true;
		}
		// Check if the first and last characters are the same
		if (str.charAt(start)!=str.charAt(end)) {
			return false; // false if different
		} else {
			return checkPalindrome(str, start+1, end-1); // check the next pair if same
		}
	}

}
