package Quiz1;

public class Q4 {

	public static void main(String[] args) {
		double[] arr = {8,6,19,2,3,2,1};
		System.out.println("Maximum is "+max(arr, 0, 6));
	}
	
	public static double max(double[] arr, int start, int end) {
		if (end == start) {
			return arr[start];
		}
		int mid = (start + end) / 2;
		double max1 = max(arr, start, mid);
		double max2 = max(arr, mid+1, end);
		if (max1 > max2) {
			return max1;
		} else {
			return max2;
		}
	}

}
