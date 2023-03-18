package Quiz1;

import java.util.Scanner;
public class Q1P1E2 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Registration starts.");
		System.out.println("Enter your username: ");
		String username = input.nextLine();
		System.out.println("Enter your password: ");
		String password = input.nextLine();
		input.close();
		System.out.print("Welcome, ");
		System.out.println(username);
	}
}
