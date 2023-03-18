package SortingPersonalCodes;

public class quickSort_Recursive {

	public static void main(String[] args) {
		int[] arr = {4,77,98,30,20,50,77,22,49,2}; // sample array
		quickSortRecursive(arr,0,arr.length-1);
		System.out.print("Sorted result: ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();		
	}
	
	public static void quickSortRecursive(int[] arr, int start, int end) {
		if (start >= end) return; // base case
		int pivot = partition(arr, start, end); // pivot position is fixed
		// Handle the rest of sorting to two "workers"
		quickSortRecursive(arr, start, pivot-1);
		quickSortRecursive(arr, pivot+1, end);
	}
	
	public static int partition(int[] arr, int start, int end) {
		// Take the end as pivot
		// Keep switching the elements smaller than the pivot to the front
		int count = start - 1, temp;
		for (int i=start; i<end; i++) {
			if (arr[i]<arr[end]) {
				count++;
				temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
			}
		}
		// Then switch the pivot to the position after the last element smaller than pivot
		temp = arr[end];
		arr[end] = arr[count+1];
		arr[count+1] = temp;
		return count+1;
	}

}
