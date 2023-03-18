package Final;

import java.util.Scanner;
//import java.util.ArrayList;

public class Exercise1 {

	public static void main(String[] args) {
		
		// Create an array
		Scanner input = new Scanner(System.in);
		System.out.print("Create an integer array. Enter its length: ");
		int length = input.nextInt();
		int[] arr = new int[length];
		for (int i=0; i<length; i++) {
			System.out.print("Enter the element at position "+i+": ");
			arr[i] = input.nextInt();
		}
		System.out.println();
		input.close();
		
		/*
		// Show the array before sorting
		System.out.print("Array before sorting: { ");
		for (int i=0; i<length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("}");
		*/
		
		// Algorithm one: merge sort
		// Use the code provided by professor. The code is below main.
		
		// Create an array same as arr
		int[] arr1 = new int[length];
		for (int i=0; i<length; i++) {
			arr1[i] = arr[i];
		}
		
		// Show the array before merge sort
		System.out.print("Array before merge sort: { ");
		for (int i=0; i<length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println("}");
		
		mergeSort(arr1, 0, arr.length-1);
		
		// Show the array after merge sort
		System.out.print("Array after merge sort: { ");
		for (int i=0; i<length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println("}");
		
		// Algorithm two: quick sort
		// Use the code provided by professor. The code is below main.
		
		// Create an array same as arr
		int[] arr2 = new int[length];
		for (int i=0; i<length; i++) {
			arr2[i] = arr[i];
		}
		
		// Show the array before quick sort
		System.out.print("Array before quick sort: { ");
		for (int i=0; i<length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println("}");

		quickSort(arr2, 0, arr.length-1);
		
		// Show the array after quick sort
		System.out.print("Array after quick sort: { ");
		for (int i=0; i<length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println("}");
		
		// Algorithm three: BST
		// Use the code provided by professor. The code is below main.
		
		// Create an array same as arr
		int[] arr3 = new int[length];
		for (int i=0; i<length; i++) {
			arr3[i] = arr[i];
		}
		
		// Show the array before BST sort
		System.out.print("Array before quick sort: { ");
		for (int i=0; i<length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println("}");
		
		BinarySearchTree BST = new BinarySearchTree();
		for (int i=0; i<length; i++) {
			BST.insert(arr3[i]);
		}
		arr3 = BST.traverseInOrder(length);
		
		// Show the array after BST sort
		System.out.print("Array after quick sort: { ");
		for (int i=0; i<length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println("}");
		
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
