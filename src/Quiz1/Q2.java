package Quiz1;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(char_most ("ssstring",'s','g'));
		System.out.println(char_most ("stringgg",'s','g'));
		System.out.println(char_most ("string",'s','g'));

	}
	
	public static char char_most (String sample, char char1, char char2) {
		int length = sample.length();
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < length; i++){
			if (char1 == sample.charAt(i)) {
				num1 += 1;
			} else if (char2 == sample.charAt(i)) {
				num2 += 1;
			}
		} // for loop
		if (num1 > num2) {
			return char1;
		} else if (num1 < num2) {
			return char2;
		} else {
			return char1;//unfair though
			//System.out.println("Two characters occur equally.");
		}
	}

}

//Consult: https://www.tutorialspoint.com/java/java_string_length.htm
//also https://www.javatpoint.com/char-keyword-in-java