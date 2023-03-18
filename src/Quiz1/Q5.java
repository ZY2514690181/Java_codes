package Quiz1;

public class Q5 {

	public static void main(String[] args) {
		int[] arr = {13,20,22,26,30,41,50,60};
		int k = 50;
		BinarySearch(k, arr, 0, 7);
	}
	
	public static int BinarySearch(int key, int[] arr, int LI, int HI) {
		if (LI > HI) {
			System.out.println("The key does not exist!");
			return -1;
		}
		int mid = (LI + HI) / 2;
		if (key == arr[mid]) {
			System.out.println("The key is found! The array index is "+mid+".");
			return mid;
		} else if (key < arr[mid]){
			return BinarySearch(key, arr, LI, mid-1);
		} else {
			return BinarySearch(key, arr, mid+1, HI);
		}
	}

}
