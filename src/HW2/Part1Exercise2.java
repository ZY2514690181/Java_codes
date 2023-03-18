package HW2;

import java.util.Scanner;

public class Part1Exercise2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a long string with more than 3 words. The number of words should be a multiple of 3.");
		// Assume the user enters a string that follows the rule above
		String str = input.nextLine();
		// Cousult https://stackoverflow.com/questions/3214002/splitting-a-space-separated-list
		String[] strList1 = str.split(" ");
		input.close();
		String[] strList2 = findShortests(strList1);
		System.out.println("Result:");
		for (int i=0; i<strList2.length; i++) {
			System.out.print(strList2[i]);
			if (i<strList2.length-1) {
				System.out.print(" ");
			}
		}
	}
	
	public static String[] findShortests(String[] strList1) {
		// convert into an array of words
		String[] strList2 = new String[strList1.length/3];
		String shortest = "";
		for (int i=0; i<strList1.length; i++) {
			// First set the leading word as the shortest
			// In else, compare if the following words are shorter
			if (i%3==0) {
				shortest = strList1[i];
			} else {
				if (strList1[i].length() < shortest.length()) {
					shortest = strList1[i];
				}
			}
			// Add the shortest of every 3 words to a string to be returned
			if (i%3==2) {
				strList2[i/3] = shortest;
			}
		}
		return strList2;
	}
	
	// Running time is O(n) because single for loop dominates the code

}
