package chap9.sortsearch;

import util.DataFeeder;
import main.*;

/*
 * implementation of Merge sort:
 * algo: break array into n array[] and merge the sorted array to build 
 * up a final array
 */
public class Chap9_mergesort extends Chapter {

	@Override
	public void run() {
		int[] arr = DataFeeder.getUnsortedArray3();
		int[] result = mergeSort(arr, 0, arr.length - 1);
		this.showArr(result);
	}
	
	private int[] mergeSort(int[] arr, int start, int end) {
		if (start >= end) {
			int[] tmp = new int[1];
			tmp[0] = arr[start];
			return tmp;
		}
		
		int mid = (start + end) / 2;
		int[] left = mergeSort(arr, start, mid);
		int[] right = mergeSort(arr, mid + 1, end);
		
		int[] result = merge(left, right);
		
		return result;
	}
	
	//merge two sorted arrays into a new sorted array
	private int[] merge(int[] a, int[] b) {
		int length = a.length + b.length;
		int[] arr = new int[length];
		
		int ai = 0, bi = 0;
		int i = 0;
		
		while (i < arr.length) {
			
			if (ai >= a.length) {
				arr[i++] = b[bi++];
				continue;
			}
			
			if (bi >= b.length) {
				arr[i++] = a[ai++];
				continue;
			}
			
			if (a[ai] < b[bi]) {
				arr[i++] = a[ai++];
			}
			
			else {
				arr[i++] = b[bi++];
			}
		}
		return arr;
	}
}


