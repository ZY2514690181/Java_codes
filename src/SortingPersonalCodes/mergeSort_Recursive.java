package SortingPersonalCodes;

public class mergeSort_Recursive {

	public static void main(String[] args) {
		int[] arr = {4,77,98,30,20,50,77,22,49,2}; // sample array
		mergeSortRecursive(arr,0,arr.length-1);
		System.out.print("Sorted result: ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void mergeSortRecursive(int[] arr, int start, int end) {
		// basic case, leaving only one element
		if (start >= end) {
			return;
		}
		int mid = (start+end)/2;
		// Assign the task to two smaller "workers"
		mergeSortRecursive(arr, start, mid);
		mergeSortRecursive(arr, mid+1, end);
		merge(arr, start, mid, end);
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		// We have an array who is divided into two parts, each sorted
		// Merge two sorted parts into one sorted part
		int[] left=new int[mid-start+1];
		int[] right=new int[end-mid]; // end-(mid+1)+1
		for (int i=0; i<mid-start+1; i++) {
			left[i]=arr[start+i];
		}
		for (int i=0; i<end-mid; i++) {
			right[i]=arr[mid+1+i];
		}
		int i=0, j=0, k=0;
		// Keep comparing the smallest of left and right until one of them is all done
		while (i<mid-start+1&&j<end-mid) {
			if (left[i]<right[j]) {
				arr[start+k]=left[i];
				i++;
				k++;
			} else {
				arr[start+k]=right[j];
				j++;
				k++;
			}
		}
		// Exit while loop when one of left and right is added to arr
		if (i<mid-start+1) {
			while (k<end-start+1) {
				arr[start+k]=left[i];
				i++;
				k++;
			}
		} else {
			while (k<end-start+1) {
				arr[start+k]=right[j];
				j++;
				k++;
			}
		}

	} // end of merge()

}
