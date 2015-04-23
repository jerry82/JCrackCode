package chap1.arraystring;

import main.*;
import util.*;

/*
 * solve Chapter 1.3: remove duplicated characters w/o using buffer
 * algo: if not use bufer it would take O(n^2) to check the duplication
 * if using buffer i.e bucket array for checking duplication it will take only O(n) for the operation
 * method1 (w/o any buffer)
 * method2 (with buffer to store the number of existence of a character)
 */

public class Chap13 extends Chapter {
	@Override 
	public void run() {
		String str1 = DataFeeder.getNotUniueCharacterString();
		truncateWithBuffer(str1);
	}
	
	private void truncateNoBuffer(String str) {
		if (str == null) return;
		if (str.length() < 2) return;
		
		char[] chars = str.toCharArray();		
		System.out.println("before: " + String.valueOf(chars));

		int l = str.length();
		int last = 1;
		boolean dup = true;
		for (int i = 1; i < l; i++) {
			//check duplicate
			dup = false;
			for (int j = 0; j < i; j++) {
				if (chars[i] == chars[j]) {
					dup = true;
					break;
				}
			}

			if (!dup) {
				chars[last] = chars[i];
				last++;
			}
		}
		
		//null character
		for (int k = last; k < l; k++) 
			chars[k] = 0;
		
		System.out.println("after: " + String.valueOf(chars));
	}
	
	private void truncateWithBuffer(String str) {
		if (str == null) return;		
		if (str.length() < 2) return;

		int SIZE = 256;
		int l = str.length();
		int last = 0;
		int[] buffer = new int[SIZE]; 
		char[] chars = str.toCharArray();
		
		System.out.println("before: " + String.valueOf(chars));
		
		for (int i = 0; i < l; i++) {
			int id = (int) chars[i];
			//duplication found
			if (buffer[id] > 0) {
				continue;
			}
			else {
				chars[last++] = chars[i];
				buffer[id]++;
			}
		}
		
		for (int k = last; k < l; k++) {
			chars[k] = 0;
		}
		
		System.out.println("after: " + String.valueOf(chars));
	}
}
