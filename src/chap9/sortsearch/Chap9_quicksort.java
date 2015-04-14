package chap9.sortsearch;

import main.*;
import util.*;

/*
 * implementation of QuickSort
 */
public class Chap9_quicksort extends Chapter {
	
	@Override
	public void run() {
		int[] arr = DataFeeder.getUnsortedArray1();
		
		quickSort(arr, 0, arr.length - 1);
	}
	
	//asc order
	public void quickSort(int[] array, int start, int end) {
		
		if (start >= end)
			return;
		
		int pI = start;
		int left = start;
		int right = end;
		
		while (left != right) {
			
			while ((array[pI] < array[right]) && left < right) {
				right--;
			}
			
			//swap
			if (array[pI] >= array[right]) {
				int tmp2 = array[pI]; array[pI] = array[right]; array[right] = tmp2;				
				pI = right; 
			}
			
			while ((array[left] <= array[pI]) && left < right) {
				left++;
			}
			
			//swap
			if (array[left] >= array[pI]) {
				int tmp = array[left]; array[left] = array[pI]; array[pI] = tmp;
				pI = left;
			}
		}
		
		System.out.println("piv: " + pI);
		showArray(array);
		quickSort(array, start, pI - 1);
		quickSort(array, pI + 1, end);
	}

	private void showArray(int[] array) {
		for (int i : array) {
			System.out.format(" %d ", i);
		}
		System.out.println();
	}
}
