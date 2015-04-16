package chap9.sortsearch;

import java.util.*;

import util.DataFeeder;
import main.*;


/*
 * implementation of Radix Sort
 */
public class Chap9_radixsort extends Chapter {
	@Override
	public void run() {
		int[] arr = DataFeeder.getUnsortedArray3();
		
		radixSort(arr);
		
		this.showArr(arr);
	}
	
	private void radixSort(int[] arr) {
		//defind linkedlist array
		LinkedList<Integer>[] lists = new LinkedList[10]; 
		
		int bit = 1;
		boolean allZeros = false;
		
		while (!allZeros) {
			allZeros = true;
			for (int i = 0; i < arr.length; i++) {
				int tmp = getNumberAt(arr[i], bit);
				
				if (lists[tmp] == null) 
					lists[tmp] = new LinkedList<Integer>();
				
				lists[tmp].add(arr[i]);
				if (tmp != 0) 
					allZeros = false;
			}
			arrange(lists, arr);
			bit++;
		}
	}
	
	//arrange the temporary sorted array back to array
	private void arrange(LinkedList<Integer>[] lists, int[] arr) {
		
		int idx = 0;
		for (LinkedList<Integer> list : lists) {
			if (list == null) 
				continue;
			
			while (!list.isEmpty()) {
				arr[idx++] = (int)list.removeFirst();
			}
		}
	}
	
	private int getNumberAt(int number, int bit) {
		return (number % (int)Math.pow(10, bit)) / ((int)Math.pow(10, bit - 1));
	}
}
