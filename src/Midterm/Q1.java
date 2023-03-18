// For this question, assume the array has a length of 2 or more.
// method 1 worst case O(n^2), best case O(n^2)
// method 2 worst case O(n^2), best case O(n)
// method 3 worst case O(n^2), best case O(n^2)
// The method 1 is directly find answers. Method 2 and 3 sort the array before finding answers.
// If use the mergeSort to sort array first and then find answers, worst case is O(n*logn), but the code is not written.

package Midterm;

public class Q1 {

	public static void main(String[] args) {
		int[] arr = {33,66,2,9,40,1,89};
		Method1(arr);
		Method2(arr);
		Method3(arr);
	}
	
	public static void Method1(int[] arr) {
		int min = arr[0] - arr[1];
		if (min<0) min = 0 - min;
		int num1 = arr[0];
		int num2 = arr[1];
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length; j++) {
				int difference = arr[i]-arr[j];
				if (difference<0) {
					difference = 0 - difference;
				}
				if (i!=j && difference<min) {
					min = difference;
					num1 = arr[i];
					num2 = arr[j];
				} // end of if
			}
		}
		System.out.println("Method 1 result");
		System.out.println("Running time: O(n^2) for best and worst case");
		System.out.println("The closest pair are "+num1+" and "+num2);
		System.out.println("Method 1 ends");
	} // end of Method1
	
	public static void Method2(int[] arr) {
		int[] arr2 = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			arr2[i] = arr[i];
		}
		insertionSort(arr2);
		//for (int i=0; i<arr.length; i++) {
		//	System.out.println(arr2[i]);
		//}
		int[] arr3 = new int[arr.length-1];
		for (int i=0; i<arr.length-1; i++) {
			arr3[i] = arr2[i+1] - arr2[i];
		}
		insertionSort(arr3);
		for (int i=0; i<arr.length-1; i++) {
			if (arr2[i+1]-arr2[i]==arr3[0]) {
				System.out.println("Method 2 result");
				System.out.println("Running time: O(n^2) for worst case, O(n) for best case");
				System.out.println("The closest pair are "+arr2[i+1]+" and "+arr2[i]);
				System.out.println("Method 2 ends");
			}
		}
	}
	
	public static void Method3(int[] arr) {
		int[] arr2 = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			arr2[i] = arr[i];
		}
		bubbleSort(arr2);
		//for (int i=0; i<arr.length; i++) {
		//	System.out.println(arr2[i]);
		//}
		int[] arr3 = new int[arr.length-1];
		for (int i=0; i<arr.length-1; i++) {
			arr3[i] = arr2[i+1] - arr2[i];
		}
		bubbleSort(arr3);
		for (int i=0; i<arr.length-1; i++) {
			if (arr2[i+1]-arr2[i]==arr3[0]) {
				System.out.println("Method 3 result");
				System.out.println("Running time: O(n^2) for worst case and best case");
				System.out.println("The closest pair are "+arr2[i+1]+" and "+arr2[i]);
				System.out.println("Method 3 ends");
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		int temp;
		int size = arr.length;
		for (int i=0; i<size-1; i++) {
			for (int j=0; j<size-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}
	
	public static void insertionSort(int[] arr) {
		int n = arr.length;
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
