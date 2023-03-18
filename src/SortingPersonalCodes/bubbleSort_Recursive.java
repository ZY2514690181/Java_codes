package SortingPersonalCodes;

public class bubbleSort_Recursive {

	public static void main(String[] args) {
		int[] arr = {4,77,98,30,20,50,77,22,49,2}; // sample array
		bubbleSortRecursive(arr, 0, arr.length-1);
		System.out.print("Sorted result: ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void bubbleSortRecursive(int[] arr, int position, int end) {
		// position for changing the elements at one and next position
		// end for going a new round after finishing one round
		// end is the position of the last unsorted element of array
		if (end == 0) {
			// all sorted
			// System.out.println("end is 0");//
			return;
		}
		if (position == end) {
			// System.out.println("Position equal to end.");//
			bubbleSortRecursive(arr, 0, end-1);
			return; // Error occurs if this return is missed.
		} else if (arr[position]>arr[position+1]) {
			int temp = arr[position];
			arr[position] = arr[position+1];
			arr[position+1] = temp;
			// System.out.println("Switch "+position+" and "+(position+1));//
		}
		bubbleSortRecursive(arr, position+1, end);
		return; // Error occurs if this return is missed.
	}
	
}
