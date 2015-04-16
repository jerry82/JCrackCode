package chap9.sortsearch;

import util.DataFeeder;
import main.*;

/* 
 * implementation of Insertion sort
 * alg: pick a number at pos nth element, check all element from the left, move checked
 * element to the right if > than the pick value
 * if not insert the picked value in front of the smaller value
 * O(n*n)
 * in place sort
 */
public class Chap9_insertionsort extends Chapter {
	
	@Override
	public void run() {
		int[] arr = DataFeeder.getUnsortedArray2();
		insertionSort(arr);
		this.showArr(arr);
	}
	
	
	//in place sort with O(n^2)
	public void insertionSort(int[] arr) {
		if (arr == null) return;
		for (int i = 0; i < arr.length; i++) {
			 int tmp = arr[i];
			 
			 for (int j = i - 1; j >= 0; j--) {
				 if (arr[j] > tmp) {
					 arr[j + 1] = arr[j];
					 arr[j] = tmp;
				 }
			 }
		}
	}
	
}
