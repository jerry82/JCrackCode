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
}
