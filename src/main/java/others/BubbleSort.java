package others;

/*Bubble Sort is the sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.*/

public class BubbleSort {

	public static void main(String[] args) {
		Integer arr[] = { 10, 2, 4, 3, 1, 6, 9 };
		int temp;
		Boolean swapped = Boolean.FALSE;
		System.out.println("Array is: ");
		printArray(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			swapped = Boolean.FALSE;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = Boolean.TRUE;
				}
			}
			// If no elements are swapped by the inner loop, then break
			if (swapped == Boolean.FALSE)
				break;
		}
		System.out.println("\n\nSorted array: ");
		printArray(arr);
	}

	private static void printArray(Integer[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}
}
