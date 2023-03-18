package SortingClassNotes;

public class bubble_selection_insertion_Sort {

	public static void main(String[] args) {
		
		int[] arr1 = {123,102,154,106,108,176,104};
		int[] arr2 = {223,202,254,206,208,276,204};
		int[] arr3 = {323,302,354,306,308,376,304};
		
		System.out.println("Show initial array1.");
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		bubbleSort(arr1);
		System.out.println("Show sorted array1.");
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		
		System.out.println("Show initial array2.");
		for (int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		selectionSort(arr2);
		System.out.println("Show sorted array2.");
		for (int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();

		System.out.println("Show initial array3.");
		for (int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		insertionSort(arr3);
		System.out.println("Show sorted array3.");
		for (int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();

	}
	
	public static void bubbleSort(int[] arr) {
		int temp;
		for (int i=0; i<arr.length-1; i++) {
			for (int j=0; j<arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			} // for loop with j
		} // for loop with i
		
	}
	
	public static void selectionSort(int[] arr) {
		int temp, min;
		for (int i=0; i<arr.length; i++) {
			min = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j]<arr[min]) {
					min = j;
				}
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void insertionSort(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			int num = arr[i];
			int j = i;
			while (j>0 && arr[j-1]>num) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = num;
		}
	}


}
