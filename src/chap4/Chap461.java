package chap4;

import java.util.LinkedList;

import main.Chapter;

/*
 * implementation linked list reversion
 */
public class Chap461 extends Chapter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(9);
		list.addLast(5);
		list.addLast(8);
		
		LinkedList<Integer> result = getReverse(list);
		for (int i : result) {
			System.out.format(" %d ", i);
		}
	}
	
	public LinkedList<Integer> getReverse(LinkedList<Integer> input) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		for (int i : input) {
			result.addFirst(i);
		}
		
		return result;
	}
	
}
