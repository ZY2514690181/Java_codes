package Yuan_Zhang_Homework_4;

import java.util.Scanner;

public class Exercise1 {
	
	public static double balance = 0.00;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner (System.in);
		int ans;
		do {
			System.out.println("Enter your selection"); //Enter the number instead of the word
			System.out.println("1.View your Balance");
			System.out.println("2.Deposit Cash");
			System.out.println("3.Withdraw Cash");
			System.out.println("4.Exit");

			ans = input.nextInt();

			if (ans==1){
				System.out.print("Your current balance is ");
				System.out.println(balance);
			} else if (ans==2) {
				System.out.print("Enter the amount you want to deposit: ");
				balance += deposit(input.nextDouble());
			} else if (ans==3) {
				System.out.print("Enter the amount you want to withdraw: ");
				balance -= withdraw(input.nextDouble());
			} else {
				System.out.println("Goodbye");
			} // Entering unclear choice means exit
			} while (ans==1 || ans==2 || ans==3); // do while loop
		
		input.close();
	
	} // main
	
	public static double deposit (double cash) {
		if (cash < 0) {
			System.out.println("You cannot deposit a negative amount");
			return 0; // make it 0 so adding causes no change
		} else {
			return cash;
		}
	}

	public static double withdraw (double cash) {
		if (cash < 0) {
			System.out.println("You cannot withdraw a negative amount");
			return 0; // same reason as above
		} else if (cash > balance) {
			System.out.println("Sorry you don't have enough balance");
			return 0; // same reason as above
		} else {
			return cash;
		}
	}

}

// Write the program based on the one in quiz