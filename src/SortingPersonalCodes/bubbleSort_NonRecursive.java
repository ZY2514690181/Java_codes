package SortingPersonalCodes;

public class bubbleSort_NonRecursive {

	public static void main(String[] args) {
		int[] arr = {4,77,98,30,20,50,77,22,49,2}; // sample array
		bubbleSortNonRecursive(arr);
		System.out.print("Sorted result: ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void bubbleSortNonRecursive(int[] arr) {
		int temp;
		for (int i=0; i<arr.length; i++) {
			// For every i there is a round of switches.
			// Different is means different positions of the final switch in the round.
			// When the ith round starts, i elements at the end are sorted.
			for (int j=0; j<arr.length-1-i; j++) {
				// In ith round, compare every jth element with (j+1)th element.
				// arr.length-1 is the position of final element
				// arr.length-1-i is the position of final unsorted element
				// j+1 ends at arr.length-1-i so the last j is arr.length-1-i-1
				if (arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			} // end of for loop with j
		} // end of for loop with i
	}

}
