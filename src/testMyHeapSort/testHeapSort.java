package testMyHeapSort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

import myHeapSort.Main;

public class testHeapSort {

	@Test
	public void test() {
		Integer[] arr = generateArray(31);
		Integer[] ar2 = Arrays.copyOf(arr, arr.length);
		
		Arrays.sort(arr, Collections.reverseOrder());
		Main.sortHeap(ar2);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(ar2));
		
		assertArrayEquals(arr, ar2);
		
	}
	
	private Integer[] generateArray(int size) {
		Integer[] arr = new Integer[size];
		Random rnd = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(90) + 10;
		}
		
		return arr;
	}

}
