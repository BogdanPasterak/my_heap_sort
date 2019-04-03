package myHeapSort;

import java.util.Arrays;

public class Main {
	private static int rows;

	public static void main(String[] args) {
		EclipseTools.fixConsole();
		Integer[] arr = { 15, 17, 73, 21, 45, 11, 87, 55, 26, 17, 70, 17, 12, 55, 99 };

		sortHeap(arr);

	}

	public static void sortHeap(Integer[] arr) {
		// calculate number of rows
		rows = 0;
		int length = arr.length;
		do {
			rows++;
		} while ((length >>= 1) > 0);

		//printHeap(arr, arr.length, arr.length);

		// loop on all parents
		// build priority 
		for (int parent = arr.length / 2 - 1; parent >= 0; parent--) {
			// call to recursive method
			setBranch(arr, parent);
		}
		
		// loop cross rows
		for (int row = 1; row < rows; row++) {
			// selection sort have less swap
			selectionSort(arr, (1 << row) - 1, (1 << (row + 1)) - 2 );
		}
		
		
		//printHeap(arr, arr.length, arr.length);
	}

	private static void selectionSort(Integer[] arr, int from, int to) {
		int maxIndex, temp;
		
		for (int sorted = from; sorted < to; sorted++) {
			maxIndex = sorted;
			for (int index = sorted + 1; index <= to; index++ ) {
				if (arr[index] > arr[maxIndex])
					maxIndex = index;
			}
			if (maxIndex != sorted) {
				// swap
				//System.out.println("Swap siblings");
				//printHeap(arr, sorted, maxIndex);
				temp = arr[sorted];
				arr[sorted] = arr[maxIndex];
				arr[maxIndex] = temp;
				// set branch with lower element
				setBranch(arr, maxIndex);
			}
		}
		
	}

	private static void setBranch(Integer[] arr, int root) {
		int left = root * 2 + 1;
		
		if (left == arr.length -1 ) {
			// single last one 
			//System.out.println("Branch single -> " + root);
			if (arr[left] > arr[root])
				swap(arr, left, root);
		} else if (left < arr.length -1 ) {
			if (arr[left] > arr[left + 1]) {
				if (arr[left] > arr[root]) {
					//System.out.println("Branch left -> " + root);
					swap(arr, left, root);
				}
			} else {
				if (arr[left + 1] > arr[root]) {
					//System.out.println("Branch right -> " + root);
					swap(arr, left + 1, root);
				}
			}
		}
	}

	private static void swap(Integer[] arr, int child, int parent) {
		int temp;

		// swap parent and child
		//printHeap(arr, child, parent);
		temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;

		// update child
		setBranch(arr, child);
	}

	private static void printHeap(Integer[] arr, int swap1, int swap2) {
		// number of rows in heap
		//int rows = (int) Math.floor(Math.log(arr.length) / Math.log(2)) + 1;
		// use global rows
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
