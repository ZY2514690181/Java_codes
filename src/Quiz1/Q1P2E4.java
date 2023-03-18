package Quiz1;

import java.util.Scanner;
public class Q1P2E4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		while (true){
			System.out.println ("What is the capital of Morocco?");
			System.out.println ("1.Tangier\n2.Rabat\n3.Casablanca\n4.Marrakech");
			String ans = input.nextLine();
			if (ans.equals("Rabat")) {
				System.out.println("Correct");
				break;
			} else {
				System.out.println("Incorrect");
			}
		}
		input.close();

	}

}
