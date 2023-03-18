package Midterm;

public class Q3 {

	public static void main(String[] args) {
		String[] str = {"word1","word2","word3"};
		Stack S = new Stack(str);
		Method1(S);
		// for loop below for testing
		/*for (int i=0; i<S.str.length; i++) {
			System.out.print(S.str[i]+" ");
		}*/
	}
	
	// This method is equivalent to two for loops. Running time is O(n*n).
	public static void Method1(Stack S) {
		if (S.isEmpty()) {
			return;
		} else {
			String temp = S.pop();
			//System.out.println("String length: "+S.str.length);//
			Method1(S);
			//System.out.println("String length: "+S.str.length);//
			S.push(temp);
		}
		
	}

}
