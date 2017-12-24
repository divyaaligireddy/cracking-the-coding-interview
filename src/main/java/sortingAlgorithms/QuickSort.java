package sortingAlgorithms;

import java.util.Arrays;

/*QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.*/

public class QuickSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 10, 34, 2, 56, 7, 67, 88, 42 };
		System.out.println("Unsorted Array: ");
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("\nSorted Array: ");
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(Integer[] arr, int lowerIndex, int higherIndex) {
		int pivot = arr[(lowerIndex + higherIndex) / 2], temp;
		int i = lowerIndex;
		int j = higherIndex;
		if (lowerIndex > higherIndex)
			return;
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (pivot < arr[j])
				j--;
			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (lowerIndex < j)
			quickSort(arr, lowerIndex, j);
		if (higherIndex > i)
			quickSort(arr, i, higherIndex);
	}
}
