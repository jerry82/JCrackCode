package chap1.arraystring;

import main.*;
import util.*;

/*
 * solve Chapter 17: iterate a matrix, if element in NxM matrix = 0; set all row and column elements to 0
 * algo: iterate through 2d array and store the position of 0 element to 2 arrays rows and columns
 * iterate again to set 0
 * complexity: O(NxM)
 */
public class Chap17 extends Chapter {
	@Override
	public void run() {
		int[][] arr = DataFeeder.get4x4Matrix();
		arr[0][2] = 0;
		arr[0][1] = 0;
		arr[1][2] = 0;
		setZeros(arr);
		this.show(arr);
	}
	
	private void setZeros(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		
		int[] rows = new int[N];
		int[] cols = new int[M];
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (arr[x][y] == 0) {
					rows[x] = 1;
					cols[y] = 1;
				}
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (rows[x] == 1 || cols[y] == 1) {
					arr[x][y] = 0;
				}
			}
		}
	}
}
