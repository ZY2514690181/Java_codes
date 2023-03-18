package HW2;

public class Part1Exercise1 {

	public static void main(String[] args) {
		compare("google","elgoog");
		compare("data","ata");
	}
	
	public static int compare(String str1, String str2) {
		// two strings with different lengths cannot be reverse of each other
		if (str1.length()!=str2.length()) {
			System.out.println("Method returns 0.");
			return 0;
		}
		// Count forward for one string and backward for the other
		for (int i=0; i<str1.length(); i++) {
			if (str1.charAt(i)!=str2.charAt(str1.length()-1-i)) {
				System.out.println("Method returns 0.");
				return 0;
			}
		}
		System.out.println("Method returns 1.");
		return 1;
	}
	
	// A single for loop dominates the code. Running time is O(n).

}
