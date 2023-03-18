package Lab3;

public class Question2 {

	public static void main(String[] args) {
		int[] arr = {2,4,1,3};
		System.out.println("Max: "+findmax(arr, 0));
	}
	
	public static int findmax(int[] arr, int head) {
		if (head == arr.length-1) {
			return arr[head];
		}
		else if (arr[head] > findmax(arr, head+1)) {
			return arr[head];
		}
		else {
			return findmax(arr, head+1);
		}
	}
	
}
