package ExceptionsPractice;

import java.util.Scanner;
import java.lang.ArithmeticException;

public class Exercise4 {
	
	public static int divide(int x, int y) {
		int result;
		try {
			result = x/y;
			System.out.println(result);
			return result;
		} catch (ArithmeticException e) {
			System.out.println("Divisor cannot be 0.");
			return 0;
		} finally {
			System.out.println("This is for finally.");
		}
		
	}
	
	public static int divide2(int x, int y) throws ArithmeticException {
		if (y == 0){
			throw (new ArithmeticException("Divisor cannot be 0."));
		}
		int result;
		result = x/y;
		System.out.println(result);		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		//divide(24,2);
		//divide(24,0);
		divide2(24,2);
		divide2(24,0);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter dividend: ");
		int num1 = input.nextInt();
		System.out.println("Enter divisor: ");
		int num2 = input.nextInt();
		input.close();
		divide(num1,num2);
	}

}
