package SortingClassNotes;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// create array
		int[] array = {4,5,1,3,2};
		// Array before sort
		System.out.println("Array before sort: "+Arrays.toString(array));
		// Call mergeSort()
		mergeSort(array,0,array.length-1);
		// Array after sort
		System.out.println("Array after sort: "+Arrays.toString(array));
	}
	
	// Create two temporary arrays and merge them back into main array
	public static void merge(int[] array, int start, int mid, int end) {
		// Create new temporary arrays
		int[] left = new int[mid-start+1];
		int[] right = new int[end-mid];
		// Transfer contents of first array from original array
		for (int i=0; i<left.length; i++) {
			left[i] = array[start+i];
		}
		// Transfer contents of second array from original array
		for (int i=0; i<right.length; i++) {
			right[i] = array[mid+1+i];
		}
		// i for first array, j for second array, k for main array
		int i = 0, j = 0, k = start;
		// Keep comparing as long as elements are left in both arrays
		while (i<left.length && j<right.length) {
			// If left element is smaller, add left element
			if (left[i]<=right[j]) {
				array[k] = left[i];
				i++;
			}
			// If right element is smaller, add right element
			else {
				array[k] = right[j];
				j++;
			}
			// Irrespective of which one happens, one element is always added
			k++;
		}
		// If right array is complete, transfer contents of left array
		while (i<left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		// If left array is complete, transfer contents of right array
		while (j<right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
	}
	
	// Recursive splitting (conceptual, not actual) in mergeSort()
	public static void mergeSort(int[] array, int start, int end) {
		// If there is only one element or no elements, return
		if (start>=end) {
			return;
		}
		// Find middle element to split by
		int mid = (start + end) / 2;
		// Split from start to middle
		mergeSort(array, start, mid);
		// Split from right of middle to end
		mergeSort(array, mid + 1, end);
		// Create the two temporary arrays and merge them
		merge(array, start, mid, end);
	}

}
