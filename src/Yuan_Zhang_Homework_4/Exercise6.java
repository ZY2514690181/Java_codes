package Yuan_Zhang_Homework_4;

public class Exercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// all letters: 65 to 90, 97 to 122
		System.out.println(letter());

	} // main
	
	public static char letter() {
		double x = Math.random(); // to determine whether capitalized
		if (x > 0.5) {
			return (char)((int)(65 + Math.random() * 26)); // upper case
		} else {
			return (char)((int)(97 + Math.random() * 26)); // lower case
		}
	} // method

} // Ex6

// Consult http://www.asciitable.com/ for the ASCII table