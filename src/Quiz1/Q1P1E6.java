package Quiz1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Q1P1E6 {
	public static void main(String[] args) throws FileNotFoundException {
		File text = new File ("⁨Password.txt");
		Scanner input = new Scanner (text);
		String password = input.nextLine();
		input.close();
		System.out.println("Password: ");
		System.out.println(password);
	}
}
//Consult: https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html