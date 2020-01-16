package sort;

import java.util.Arrays;

public class MyQuickSort {
	private void quickSort(int arr[], int start, int end) {
		if(start >= end) {
			return;
		}
		if(start+1 == end) {
			if(arr[start] > arr[end]) {
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;
			}
			return;
		}
		
		// select pivot
		int pivot = arr[start];
		int i = start+1,  j= end;
		// Left to right , i increment till arr[i] > pivot
		// right to left, j decrement till arr[j] < pivot
		while(i < j) {
			while(i <= end && arr[i] <= pivot) {
				i++;
			}
			while(j >= i && arr[j] > pivot) {
				j--;
			}
			
			if(j>i && arr[i] > pivot && arr[j] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if(i > end  || arr[i] > pivot) {
			i--;
		}
		// place pivot in right place. swap arr[i] and pivot
		// TODO: already sorted cases. increasing and decreasing order
		if(i != start) {
			arr[start] = arr[i];
			arr[i] = pivot;
		}
		quickSort(arr, start, i-1);
		quickSort(arr, i+1, end);
	}

	public static void main(String[] args) {
		int arr[] = new int[] {3,2,4,1,5,6};
		Integer arr1[] = new Integer[] {1,2}; // this valid syntax
		new MyQuickSort().quickSort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
		arr = new int[] {1,2,3,4,5,6};
		new MyQuickSort().quickSort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
		arr = new int[] {6,5,4,3,2,1};
		new MyQuickSort().quickSort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {6,5,4,3,2,1, 10,9,8,7};
		new MyQuickSort().quickSort(arr, 0, 9);
		System.out.println(Arrays.toString(arr));
	}

}
