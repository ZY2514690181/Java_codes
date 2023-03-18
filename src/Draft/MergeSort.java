// This algorithm fails.

package Draft;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1,2,3,6,9,8,7,4,5};
		int[] arr1 = {1,2,3,6};
		int[] arr2 = {9,8,7,4,5};
		mergeSort(arr1,arr2,0,8);
	}
	public static void merge(int[] x1, int left1, int right1, int[] x2, int left2, int right2, int[] x, int left) {
		int i1 = left1;
		int i2 = left2;
		int i = left;
		while(i1<=right1 && i2<= right2) {
			if (x1[i1]<=x2[i2]) {
				x[i]=x1[i1];
				i1++;
				i++;
			}
			else {
				x[i]=x2[i2];
				i2++;
				i++;
			}
		} // end of while
		if (i1<right1) {
			while (i1<=right1) {
				x[i]=x1[i1];
				i1++;
				i++;
			}
		}
		if (i2<right2) {
			while (i2<=right2) {
				x[i]=x2[i2];
				i2++;
				i++;
			}
		}
	}
	public static void mergeSort(int x[], int y[], int left, int right) {
		if (left==right) {
			y[left]=x[left];
			return;
		}
		int mid = (left+right)/2;
		int[] z = new int[right+1];
		mergeSort(x,z,left,mid);
		mergeSort(x,z,mid+1,right);
		merge(z,left,mid,z,mid+1,right,y,left);
	}
	
	public static void printArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
