package myHeapSort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arr = {15, 17, 73, 21, 45, 11, 87, 55, 26, 17, 91, 17, 12, 55, 99};
		
		System.out.println("Start");
		System.out.println(Arrays.toString(arr));
		
		printHeap(arr);
	}

	private static void printHeap(int[] arr) {
		// number of rows in heap 
		int rows = (int)Math.floor(Math.log(arr.length)/Math.log(2)) + 1;
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
					System.out.print(arr[count++] + offset);
				}
			}
			
			System.out.println();
		}
		System.out.println("------------------------------");
	}

}
