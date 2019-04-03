package myHeapSort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		EclipseTools.fixConsole();
		int[] arr = { 15, 17, 73, 21, 45, 11, 87, 55, 26, 17, 86, 17, 12, 55, 99 };

		sortHeap(arr);

	}

	private static void sortHeap(int[] arr) {

		printHeap(arr, arr.length, arr.length);

		// loop on all parents
		for (int parent = arr.length / 2 - 1; parent >= 0; parent--) {
			// call to recursive method
			setBranch(arr, parent);
		}
		
		printHeap(arr, arr.length, arr.length);
	}

	private static void setBranch(int[] arr, int root) {
		int left = root * 2 + 1;
		int right = left + 1;
		
		if (left == arr.length -1 ) {
			// single last one 
			//System.out.println("Branch single -> " + root);
			if (arr[left] > arr[root])
				swap(arr, left, root);
		} else if (left < arr.length -1 ) {
			if (arr[left] > arr[right]) {
				if (arr[left] > arr[root]) {
					//System.out.println("Branch left -> " + root);
					swap(arr, left, root);
				}
			} else {
				if (arr[right] > arr[root]) {
					//System.out.println("Branch right -> " + root);
					swap(arr, right, root);
				}
			}
		}
	}

	private static void swap(int[] arr, int child, int parent) {
		int temp;

		printHeap(arr, child, parent);
		temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;
		
		setBranch(arr, child);
		
	}

	private static void printHeap(int[] arr, int swap1, int swap2) {
		// number of rows in heap
		int rows = (int) Math.floor(Math.log(arr.length) / Math.log(2)) + 1;
		String offset;
		int count = 0;

		// loop for print row
		for (int row = 0; row < rows; row++) {

			// offset on front
			offset = "";
			for (int i = 0; i < Math.pow(2, rows - row) - 2; i++)
				offset += " ";
			System.out.print(offset);

			// offset between
			offset = "";
			for (int i = 0; i < Math.pow(2, rows - row + 1) - 2; i++)
				offset += " ";

			// print numbers
			for (int col = 0; col < Math.pow(2, row); col++) {
				if (count < arr.length) {
					if (count == swap1 || count == swap2)
						System.err.print(arr[count++] + offset);
					else
						System.out.print(arr[count++] + offset);
				}
			}
			System.out.println();
		}
		System.out.println("------------------------------");

	}

}
