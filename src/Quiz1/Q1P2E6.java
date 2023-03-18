package Quiz1;

import java.util.Scanner;

public class Q1P2E6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		double balance = 50;
		String Pin = "1449";
		int attempt = 0;
		boolean PinTF = false;

		System.out.println("Welcome to Citibank");
		while (attempt < 3) {
			System.out.println("Please enter your Pin: ");
			String ans1 = input.nextLine();
			attempt += 1;
			if (ans1.equals(Pin)) {
				PinTF = true;
				System.out.println("Correct pin");
				break;
			} else {
				System.out.println("Wrong pin");
			}
		}

		if (PinTF) {
			int ans2;
			do {
			System.out.println("Welcome to Citibank");
			System.out.println("Choose an option (enter the number)");
			System.out.println("1.Balance Inquiry");
			System.out.println("2.Pin Change");
			System.out.println("3.Deposit Money");
			System.out.println("4.Withdraw Money");
			System.out.println("5.Exit");

			ans2 = input.nextInt();
			

			if (ans2==1){
				System.out.println("Balance: ");
				System.out.println(balance);
			} else if (ans2==2) {
				System.out.println("Enter your new pin: ");
				input.nextLine();
				Pin = input.nextLine();
			} else if (ans2==3) {
				System.out.println("How much: ");
				balance += input.nextDouble();
			} else if (ans2==4) {
				System.out.println("How much: ");
				balance -= input.nextDouble();
			}
			} while (ans2==1 || ans2==2 || ans2==3 || ans2==4); // do while loop

		}  // when the pin entered is right

	}

}
