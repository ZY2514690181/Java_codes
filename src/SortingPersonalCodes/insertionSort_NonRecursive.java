package SortingPersonalCodes;

public class insertionSort_NonRecursive {

	public static void main(String[] args) {
		int[] arr = {4,77,98,30,20,50,77,22,49,2}; // sample array
		insertionSortNonRecursive(arr);
		System.out.print("Sorted result: ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void insertionSortNonRecursive(int[] arr) {
		for (int i=1; i<arr.length; i++) {
			// The first i elements are sorted
			int k=0;
			for (int j=0; j<i; j++) {
				// Take element at position i from the unsorted
				// Put this element at a proper position j from the sorted
				if (arr[i]>arr[j]) {
					k++;
					//System.out.println("k value increases to : "+k);//
				}
			}
			//System.out.println("k value: "+k);//
			int temp = arr[i];
			for (int j=i-1; j>=k; j--) {
				arr[j+1] = arr[j];
			}
			arr[k] = temp;
		}
	}
}
