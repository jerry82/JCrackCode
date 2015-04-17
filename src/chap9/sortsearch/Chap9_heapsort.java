package chap9.sortsearch;

import util.DataFeeder;
import main.*;

/* 
 * implementation of heap sort
 * algo: 
 * 1. create heap 
 * 2. sort the heap:
 * 	  swap root with last child (-> root is sort, bubble down new root, swap with bigger child)
 */
public class Chap9_heapsort extends Chapter {
	
	@Override
	public void run() {
		int[] arr = DataFeeder.getUnsortedArray4();
		heapsort(arr);
		this.showArr(arr);
	}
	
	public void heapsort(int[] arr) {
		int[] heap = createHeap(arr);
		
		this.showArr(heap);
		
		int arrPointer = arr.length - 1;
		int heapLast = heap.length - 1;
		
		while (arrPointer >= 0) {
			//swap root with last child
			swap(heap, 1, heapLast);
			//cut last child and put to sorted array;
			arr[arrPointer--] = heap[heapLast--];
			
			//bubble down until heap last;
			bubbleDown(heap, heapLast);
		}
	}
	
	private void bubbleDown(int[] heap, int heapLast) { 
		//1-> heapLast
		int cur = 1;
		while(heapLast > 0) {
			int leftI = leftI(cur);
			int rightI = rightI(cur);
			
			if (leftI <= heapLast && rightI <= heapLast) {
				if (heap[leftI] > heap[rightI]) {
					swap(heap, cur, leftI);
					cur = leftI;
				}
				else {
					swap(heap, cur, rightI);
					cur = rightI;
				}
			}
			else if (leftI <= heapLast) {
				swap(heap, cur, leftI);
				cur = leftI;
			}
			else if (rightI <= heapLast) {
				swap(heap, cur, rightI);
				cur = rightI;
			}
			else 
				break;
		}
	}
	
	private void swap(int[] heap, int from, int to) {
		int tmp = heap[from];
		heap[from] = heap[to];
		heap[to] = tmp;
	}
	
	//maxify heap
	private int[] createHeap(int[] arr) {
		//ignore the 0 index
		int[] heap = new int[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			heap[i + 1] = arr[i];
			bubble(heap, i + 1);
		}
		
		return heap;
	}
	
	private void bubble(int[] heap, int curI) {
		while (true) {
			int parentI = getParent(curI);
			if (parentI > 0) {
				//swap with parent
				if (heap[parentI] < heap[curI]) {
					int tmp = heap[parentI];
					heap[parentI] = heap[curI];
					heap[curI] = tmp;
					curI = parentI;
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
	}

	private int getParent(int cur) {
		int i = 0;
		i = (cur % 2) == 0 ? cur / 2 : (cur - 1) / 2;
		return i;
	}
	
	private int leftI(int cur) {
		return 2 * cur;
	}
	
	private int rightI(int cur) {
		return 2 * cur + 1;
	}
}
