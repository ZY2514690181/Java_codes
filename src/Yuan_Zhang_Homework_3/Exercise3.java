package Yuan_Zhang_Homework_3;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner (System.in);
		System.out.print("Enter the first string: ");
		String str1 = input.nextLine();
		System.out.print("Enter the second string: ");
		String str2 = input.nextLine();
		input.close();
		
		String common = "";
		int i = 0;
		while ((i < str1.length()) && (i < str2.length())) {
			if (str1.charAt(i)==str2.charAt(i)) {
				common += str1.charAt(i);
				i += 1;
			} else {
				break;
			}
			
		} // while loop
		
		if (common.length() > 0) {
			System.out.print("The common prefix is ");
			System.out.println(common);
		} else {
			System.out.println(str1+" and "+str2+" have no common prefix");
		}

	}

}