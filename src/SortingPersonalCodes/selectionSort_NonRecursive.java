package SortingPersonalCodes;

public class selectionSort_NonRecursive {

	public static void main(String[] args) {
		int[] arr = {4,77,98,30,20,50,77,22,49,2}; // sample array
		selectionSortNonRecursive(arr);
		System.out.print("Sorted result: ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void selectionSortNonRecursive(int[] arr) {
		// In selection sort, find the minimum in a round. Switch it with the first element.
		// Then keep finding minimum and switching in the following rounds.
		int temp;
		int min; // index of minimum, not minimum value itself
		for (int i=0; i<arr.length; i++) {
			// For each i, there is a round.
			// Different is means different starting positions of finding minimum in the round.
			// When the ith round starts, i elements from the start are sorted.
			min = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j]<arr[min]) {
					min = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

}
