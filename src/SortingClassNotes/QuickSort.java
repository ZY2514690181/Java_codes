package SortingClassNotes;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// create array
		int[] array = {4,5,1,3,2};
		// Array before sort
		System.out.println("Array before sort: "+Arrays.toString(array));
		// Call mergeSort()
		quickSort(array,0,array.length-1);
		// Array after sort
		System.out.println("Array after sort: "+Arrays.toString(array));		
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low<high) {
			// partition index obtained via partition
			int pi = partition(arr, low, high);
			// recursively sort sub-arrays
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}
	
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		for (int j=low; j<high; j++) {
			// if j is less than the pivot
			if (arr[j]<=pivot) {
				i++;
				// swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// swap to place the pivot in the correct position
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}

}
