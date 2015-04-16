package chap9.sortsearch;

import util.DataFeeder;
import main.*;

/* 
 * implementation of heap sort
 * in place sort with complexity = O(n^2)
 */
public class Chap9_heapsort extends Chapter {
	
	@Override
	public void run() {
		int[] arr = DataFeeder.getUnsortedArray3();
		heapsort(arr);
		this.showArr(arr);
	}
	
	public void heapsort(int[] arr) {
		
	}
}
