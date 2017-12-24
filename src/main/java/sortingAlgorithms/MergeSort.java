package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 10, 34, 2, 56, 7, 67, 88, 42 };
		System.out.println("Unsorted Array: ");
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, new Integer[arr.length], 0, arr.length - 1);
		System.out.println("\nSorted Array: ");
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(Integer[] arr, Integer[] temp, int low, int high) {
		if (high > low) {
			int middle = (low + high) / 2;
			mergeSort(arr, temp, low, middle);
			mergeSort(arr, temp, middle + 1, high);
			merge(arr, temp, low, high);
		}

	}

	private static void merge(Integer[] arr, Integer[] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int index = leftStart;
		int left = leftStart;
		int right = rightStart;
		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			} else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
	}
}
