package chap1.arraystring;

import main.*;
import util.*;

/*
 * solve Chapter 16: NxN matrix (each pixel is 4 byte), write in-place rotation algo
 * algo: rotate out-most round to inner core
 * [x, y] -> [ N - 1 - y, x] i.e N = 4 [3, 1] -> [2, 3]
 * int(N/2) is the number of edges
 *  to rotate
 * 
 * 1 2 3 
 * 3 4 5
 * 6 7 8
 * 
 * to 
 * 
 * 7 4 1
 * 8 5 2
 * 9 6 3
 * 
 */
public class Chap16 extends Chapter {
	@Override
	public void run() {
		int[][] array4 = DataFeeder.get4x4Matrix();
		show(array4);
		rotate(array4);
		show(array4);
	}
	
	private void rotate(int[][] arr) {
		int N = arr.length;
		int L = N - 1;
		int Mid = L / 2;
		
		for (int i = L; i > Mid; i--) {
			for (int j = L - i; j < i; j++) {
				
				//System.out.format(" %d,%d ", i, j);
				rotate(arr, i, j, N);
			}
			System.out.println();
		}
	}
	
	//[x, y] -> [ N - 1 - y, x] i.e N = 4 [3, 1] -> [2, 3]
	//in place swap
	private void rotate(int[][] arr, int x, int y, int N) {
		int tmp1 = arr[x][y];
		int tmp2 = tmp1;
		for (int i = 0; i < 4; i++) {
			int nextX = N - 1 - y;
			int nextY = x;

			tmp1 = tmp2;
			tmp2 = arr[nextX][nextY];
			arr[nextX][nextY] = tmp1;
			
			x = nextX;
			y = nextY;
		}
	}
}
