package Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class IOTestOut {
	public static void main(String[] agrs) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter length: ");
		String l = input.next();
		System.out.print("Enter width: ");
		String w = input.next();
		input.close();
		
		try {
			int length = Integer.parseInt(l);
			int width = Integer.parseInt(w);
			Rectangle R1 = new Rectangle(length, width);
			R1.getArea();
		} catch (NumberFormatException e) {
			System.out.println("You are entering the wrong data type!");
		}
		
	}
}