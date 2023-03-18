package Yuan_Zhang_Homework_3;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		for (int i = 65; i<= 126; i++) {
			count += 1;
			System.out.print( (char) i );
			if (count % 5 == 0) {
				System.out.print("\n");
			} else {
				System.out.print(" ");
			}
		} // for loop

	}

}

// Consult https://www.ascii-code.com/
// Consult https://www.computerhope.com/jargon/a/ascii.htm
// Consult https://stackoverflow.com/questions/5328996/java-change-int-to-ascii