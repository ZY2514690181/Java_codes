package Quiz1;

import java.util.Scanner;

public class Q1P3E9 {

	public static double checking = 50;
	public static double savings = 100;
	public static String Pin = "1449";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		
		String Username = "ZY";
		int attempt = 0;
		boolean InfoTF = false;

		System.out.println("Welcome to Citibank");
		while (attempt < 3) {
			System.out.println("Please enter your Username: ");
			String ans0 = input.nextLine();
			if (ans0.equals(Username)) {
				System.out.println("Correct username");
				break;
			} else {
				attempt += 1;
				System.out.println("Wrong username");
			}
		}
		while (attempt < 3) {
			System.out.println("Please enter your Pin: ");
			String ans1 = input.nextLine();
			if (ans1.equals(Pin)) {
				InfoTF = true;
				System.out.println("Correct pin");
				break;
			} else {
				attempt += 1;
				System.out.println("Wrong pin");
			}
		}

		if (InfoTF) {
			int ans2=0;
			do {
				System.out.println("Which account are you going to?");
				System.out.println("1.checking");
				System.out.println("2.savings");
				System.out.println("3.exit");
				ans2 = input.nextInt();
				if (ans2==1) {
					work(checking);
				} else if (ans2==2) {
					work(savings);
				}
			} while (ans2==1 || ans2==2);
			
			
		}  // InfoTF

		input.close();
	}
	
	public static void work(double balance) {
		
		Scanner input = new Scanner (System.in);
		int ans3;
		do {
			System.out.println("Welcome to Citibank");
			System.out.println("Choose an option (enter the number)");
			System.out.println("1.Balance Inquiry");
			System.out.println("2.Pin Change");
			System.out.println("3.Deposit Money");
			System.out.println("4.Withdraw Money");
			System.out.println("5.Exit");

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
			}
			} while (ans3==1 || ans3==2 || ans3==3 || ans3==4); // do while loop
			//input.close();
		} // when the pin entered is right

}

//Consult: https://study.com/academy/lesson/java-global-variable-declaration-examples.html
/* The program is modified, and for each account there are manipulations.
That is why the method takes account info and makes changes based on
that. After finishing the method, we use if and elif to deal with two
accounts' situations, and we need a do-while loop to keep performing it.
*/
 