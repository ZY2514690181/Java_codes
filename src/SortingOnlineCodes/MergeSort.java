package SortingOnlineCodes;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1,2,3,6,9,8,7,4,5};
		System.out.println("Display the initial array");
		printArray(arr);
		mergeSort(arr,0,arr.length-1);
		System.out.println("Display the sorted array");
		printArray(arr);
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int Left[] = new int[n1];
		int Right[] = new int[n2];
		for (int i=0; i<n1; i++) {
			Left[i] = arr[left+i];
		}
		for (int i=0; i<n2; ++i) {
			Right[i] = arr[mid+1+i];
		}
		int i=0, j=0, k=left;
		while(i<n1 && j<n2) {
			if (Left[i]<=Right[j]) {
				arr[k] = Left[i];
				i++;
			} else {
				arr[k] = Right[j];
				j++;
			}
			k++;
		} // end of while
		while (i<n1) {
			arr[k] = Left[i];
			i++;
			k++;
		}
		while (j<n2) {
			arr[k] = Right[j];
			j++;
			k++;
		}
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		if (left<right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public static void printArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
