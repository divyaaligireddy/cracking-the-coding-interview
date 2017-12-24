package sortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 10, 34, 2, 56, 7, 67, 88, 42 };
		int temp;
		System.out.println("Unsorted Array: ");
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		System.out.println("\nSorted Array: ");
		System.out.println(Arrays.toString(arr));
	}
}
