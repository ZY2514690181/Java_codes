package Midterm;

public class Q2 {

	public static void main(String[] args) {
		int[] arr = {3,66,6,9,40,0,89};
		System.out.println("Maximum is "+max(arr, 0, 6));
		System.out.println("Minimum is "+min(arr, 0, 6));
		System.out.println("Average is "+(double)sum(arr, 0, 7)/7);
	}
	
	public static int max(int[] arr, int start, int end) {
		if (end == start) {
			return arr[start];
		}
		int mid = (start + end) / 2;
		int max1 = max(arr, start, mid);
		int max2 = max(arr, mid+1, end);
		if (max1 > max2) {
			return max1;
		} else {
			return max2;
		}
	}
	public static int min(int[] arr, int start, int end) {
		if (end == start) {
			return arr[start];
		}
		int mid = (start + end) / 2;
		int min1 = min(arr, start, mid);
		int min2 = min(arr, mid+1, end);
		if (min1 < min2) {
			return min1;
		} else {
			return min2;
		}
	}
	public static int sum(int[] arr, int i, int n) {
		if (n==1) return arr[i];
		return sum(arr, i, n/2) + sum(arr, i+n/2, n-n/2);
	}

}
