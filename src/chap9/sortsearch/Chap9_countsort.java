package chap9.sortsearch;

import java.lang.reflect.Array;

import main.*;
import util.*;
/*
 * implementation of Count Sort
 */
public class Chap9_countsort extends Chapter {
	
	@Override
	public void run() {
		int[] arr = DataFeeder.getUnsortedArray1();
		
		countsort(arr);
		this.showArr(arr);
	}
	
	//complexity of O(2*n + k) -> O(n + k) with k:range
	public void countsort(int[] arr) {
		if (arr == null) 
			return;
		if (arr.length == 0) {
			return;
		}
		
		//preassign array with estimated range
		int RANGE = 10;
		//with all O's
		int[] countArr = new int[RANGE];
		
		//complexity O(n)
		for (int i : arr) {
			countArr[i]++;
		}
		
		//Complexity O(k) with k: range
		for (int j = 1; j < arr.length; j++) {
			countArr[j] += countArr[j-1];
		}
		
		int[] tmp = arr.clone();
		
		//O(n)
		for (int k : tmp) {
			int idx = countArr[k] - 1;
			arr[idx] = k;
			countArr[k]--;
		}
	}
}
