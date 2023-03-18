package Final;

import java.util.Scanner;

public class Exercise6 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Stack size is 20. Assume the user does not make it overflow or underflow.
		// Assume the user always follows the menu and enter the correct type.
		// Assume the user always enters a postfix expression that can be calculated.
		// e.g. 2 3 + can be calculated, but 4 5 6 - cannot.
		// Assume 0 never becomes the divisor.
		
		int ans;
		StackY theStack = new StackY();
		
		while (true) {
			
			System.out.println("Menu");
			System.out.println("1. Enter a double");
			System.out.println("2. Enter +");
			System.out.println("3. Enter -");
			System.out.println("4. Enter *");
			System.out.println("5. Enter /");
			System.out.println("6. Show result and Exit");
			
			System.out.print("Enter your choice: ");
			ans = input.nextInt();
			
			if (ans == 1) {
				System.out.print("Enter a double: ");
				theStack.push(input.nextDouble());
			} else if (ans == 2) {
				double num2 = theStack.pop();
				double num1 = theStack.pop();
				theStack.push(num1 + num2);
			} else if (ans == 3) {
				double num2 = theStack.pop();
				double num1 = theStack.pop();
				theStack.push(num1 - num2);				
			} else if (ans == 4) {
				double num2 = theStack.pop();
				double num1 = theStack.pop();
				theStack.push(num1 * num2);				
			} else if (ans == 5) {
				double num2 = theStack.pop();
				double num1 = theStack.pop();
				theStack.push(num1 / num2);				
			} else if (ans == 6) {
				System.out.print("The final result is "+theStack.pop());
				break;
			} else {
				System.out.println("Invalid input");
			}
		}
		
		input.close();
		
	}

}
