package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your word: ");
		String word = input.nextLine();
		input.close();
		if (palindrome(word)) {
			System.out.println("Your word is a palindrome.");
		} else {
			System.out.println("Your word is not a palindrome.");
		} // else

	} // main
	
	public static boolean palindrome(String word) {
		String simplified_word = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != ' ') {
			simplified_word += word.charAt(i);
			} // remove the space
			// to fully exclude punctuation, may add && ...!=',' && ...
			// assume only space may upset the programmer here to make it simple
		}
		String reverse_word = "";
		for (int i = 0; i < simplified_word.length(); i++) {
			reverse_word = simplified_word.charAt(i) + reverse_word; // reverse the order
		} // for loop
		if (simplified_word.equals(reverse_word)) {
			return true;
		} else {
			return false;
		} // else
	} // method

} // Ex9