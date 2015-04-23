package main;


/*
 * abstract class for chapter
 */
public abstract class Chapter {
	
	public abstract void run();
	
	protected void showArr(int[] arr) {
		for (int i : arr) {
			System.out.format(" %d ", i);
		}
		System.out.println();
	}
	
	protected void showArr(float[] arr) {
		for (float f : arr) {
			System.out.format(" %f ", f);
		}
		System.out.println();
	}
	
	protected void show(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				System.out.format(" %d ", arr[i][j]);
			}
			System.out.println();
		}
	}
}
