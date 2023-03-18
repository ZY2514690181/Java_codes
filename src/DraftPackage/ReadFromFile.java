package DraftPackage;

import java.util.Scanner;
import java.io.*;

public class ReadFromFile {
	
	public static void main(String[]args) throws FileNotFoundException{
		
		File CS101 = new File("/Users/zhangyuan/eclipse-workspace/Program1/src/DraftPackage/txtDraft.txt");
		Scanner scn = new Scanner(CS101);
		String password = scn.nextLine();
		System.out.println("The password is  "+ password);
	}

}


