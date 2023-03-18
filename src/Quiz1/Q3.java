package Quiz1;

import java.util.Scanner;

public class Q3 {

	public static double checking = 50;
	public static double savings = 50;
	public static double credit = 50;
	public static String Pin = "1449";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		
		int attempt = 0;
		boolean InfoTF = false;

		System.out.println("Welcome to Citibank");
		while (attempt < 3) {
			System.out.println("Please enter your Pin: ");
			String ans1 = input.nextLine();
			if (ans1.equals(Pin)) {
				InfoTF = true;
				break;
			} else {
				attempt += 1;
				System.out.println("Wrong pin");
			}
		}

		if (InfoTF) {
			int ans2=0;
			do {
				System.out.println("Welcome to Citibank");
				System.out.println("Choose an option:");
				System.out.println("1.Checking Acc.");
				System.out.println("2.Savings Acc.");
				System.out.println("3.Credit Card Acc.");
				System.out.println("4.Exit");
				ans2 = input.nextInt();
				if (ans2==1) {
					System.out.println("You are in Checking Acc.");
					work(checking);
				} else if (ans2==2) {
					System.out.println("You are in Savings Acc.");
					work(savings);
				} else if (ans2==3) {
					System.out.println("You are in Credit Card Acc.");
					work(credit);
				}
			} while (ans2==1 || ans2==2 || ans2==3);
			
			
		}  // InfoTF

		input.close();
	}
	
	public static void work(double balance) {
		
		Scanner input = new Scanner (System.in);
		int ans3;
		do {
			System.out.println("Choose an option (enter the number)");
			System.out.println("1.Balance Inquiry");
			System.out.println("2.Pin Change");
			System.out.println("3.Deposit Money");
			System.out.println("4.Withdraw Money");
			System.out.println("5.Transfer Money");
			System.out.println("6.Exit");

			ans3 = input.nextInt();

			if (ans3==1){
				System.out.println("Balance: ");
				System.out.println(balance);
			} else if (ans3==2) {
				System.out.println("Enter your new pin: ");
				input.nextLine();
				Pin = input.nextLine();
			} else if (ans3==3) {
				System.out.println("How much: ");
				balance += input.nextDouble();
			} else if (ans3==4) {
				System.out.println("How much: ");
				balance -= input.nextDouble();
			} else if (ans3==5) {
				System.out.println("How much: ");
				double transfer = input.nextDouble();
				balance -= transfer;
				System.out.println("To which account?");
				System.out.println("1.Checking Acc.");
				System.out.println("2.Savings Acc.");
				System.out.println("3.Credit Card Acc.");
				int ans4 = input.nextInt();
				if (ans4==1) {
					checking += transfer;
				} else if (ans4==2) {
					savings += transfer;
				} else if (ans4==3) {
					credit += transfer;
				} else {
					balance += transfer;
				}
			}
			} while (ans3==1 || ans3==2 || ans3==3 || ans3==4 || ans3==5); // do while loop
			//input.close();
		} // when the pin entered is right

}

//Consult: https://study.com/academy/lesson/java-global-variable-declaration-examples.html
/* The program is modified, and for each account there are manipulations.
That is why the method takes account info and makes changes based on
that. After finishing the method, we use if and elif to deal with two
accounts' situations, and we need a do-while loop to keep performing it.
*/
 