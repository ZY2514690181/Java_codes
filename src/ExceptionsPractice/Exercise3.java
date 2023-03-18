package ExceptionsPractice;

import java.util.Scanner;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.*;

public class Exercise3 {

	public static void main(String[] args) throws Exception {
		
		File Infile = new File("/Users/zhangyuan/eclipse-workspace/Program1/src/ExceptionsPractice/TargetFile.txt");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the line number: ");
		int num = input.nextInt();
		Scanner scn = new Scanner(Infile);
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(Infile))){
			for (int i = 0; i < num; i++)
				br.readLine();
			line = br.readLine();
			System.out.println(line);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("This is for finally.");
		}

	}

}
