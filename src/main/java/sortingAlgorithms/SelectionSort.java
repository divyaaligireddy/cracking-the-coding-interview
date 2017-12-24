package sortingAlgorithms;

import java.util.Arrays;

/*Selection Sort is the sorting algorithm that works by repeatedly finding the minimum number in the array 
 * and placing it in the beginning.*/

public class SelectionSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 10, 34, 2, 56, 7, 67, 88, 42 };
		int lowIndex = 0;
		Integer temp;
		System.out.println("Unsorted Array: ");
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			lowIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[lowIndex])
					lowIndex = j;
			}
			temp = arr[i];
			arr[i] = arr[lowIndex];
			arr[lowIndex] = temp;
		}
		System.out.println("\nSorted Array: ");
		System.out.println(Arrays.toString(arr));
	}

}
