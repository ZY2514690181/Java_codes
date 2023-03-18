package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int num = input.nextInt(); // assume positive integer entered
		input.close();
		System.out.print("the number in reverse order: ");
		System.out.println(reverse_int(num));

	} // main
	
	public static int reverse_int(int num) {
		int reverse_num = 0;
		while (num > 0) {
			reverse_num = reverse_num * 10 + num % 10;
			// *10 to give a space for the next number
			// %10 the last digit becomes the first
			num = (num - num % 10) / 10; // remove last digit of the old number
		} // while loop
		return reverse_num;
	} // method

} // Ex8