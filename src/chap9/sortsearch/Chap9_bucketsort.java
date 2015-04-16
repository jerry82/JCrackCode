package chap9.sortsearch;

import java.util.*;

import util.DataFeeder;
import main.*;


/*
 * implementation of bucket sort
 * algo: divide the set into small bucket and apply insertion sort to that bucket;
 * depends on the data to group into bucket
 * the mapping is designed specific to data set
 */
public class Chap9_bucketsort extends Chapter {
	@Override
	public void run() {
		float[] arr = DataFeeder.getUnsortedFloatArray1();
		this.showArr(arr);
		bucketSort(arr);
		this.showArr(arr);
	}
	
	//this implementation is specific to data set
	//i.e design 10buckets for this 
	public void bucketSort(float[] arr) {
		List<List<Float>> lists = getInitList(10);
		
		for (float f : arr) {
			int i = mapIndex(f);
			List<Float> tmp = lists.get(i);
			addSort(tmp, f);
		}
		
		//combine 
		int id = 0;
		while (id < arr.length) {
			for (int i = 0; i < lists.size(); i++) {
				List<Float> tmp = lists.get(i);
				if (tmp.size() > 0) {
					for (float f : tmp) {
						arr[id++] = f;
					}
				}
			}
		}
	}
	
	private void addSort(List<Float> list, float val) {
		if (list.size() == 0) {
			list.add(val);
			return;
		}
		
		list.add(val);
		int curL = list.size() - 1;
		for (int i = curL - 1; i >= 0; i--) {
			if (val >= list.get(i)) {
				continue;
			}
			else {
				float tmp = list.get(i);
				list.set(i + 1, tmp);
				list.set(i, val);
			}
		}
	}
	
	private int mapIndex(float val) {
		int id = 0;
		id = (int) (10 * val);
		return id;
	}
	
	private List<List<Float>> getInitList(int size) {
		List<List<Float>> lists = new ArrayList<List<Float>>(size);
		
		for (int i = 0; i < size; i++) {
			lists.add(new ArrayList<Float>());
		}
		
		return lists;
	}
}
