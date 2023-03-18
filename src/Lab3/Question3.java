package Lab3;

public class Question3 {

	public static void main(String[] args) {
		int[] arr = {-2,-1,1,2};
		System.out.println("Sum of even or negative numbers: "+findsum(arr, 0));

	}
	
	public static int findsum(int[] arr, int head) {
		if (head == arr.length) {
			return 0;
		}
		else if (arr[head]<0 || arr[head]%2==0) {
			return arr[head] + findsum(arr, head+1);
		}
		else {
			return findsum(arr, head+1);
		}

	}

}
