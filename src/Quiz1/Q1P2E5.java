package Quiz1;

import java.util.Scanner;

public class Q1P2E5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		int attempt = 0;
		while (attempt < 3){
			System.out.println ("What is the capital of Morocco?");
			System.out.println ("1.Tangier\n2.Rabat\n3.Casablanca\n4.Marrakech");
			String ans = input.nextLine();
			attempt += 1;
			if (ans.equals("Rabat")) {
				System.out.println("correct");
				break;
			} else if (attempt == 3){
				System.out.println("You get it wrong! It's Rabat.");
			}
		}
		input.close();

	}
}
