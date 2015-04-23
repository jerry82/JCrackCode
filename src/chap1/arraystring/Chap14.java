package chap1.arraystring;

import main.*;
import util.*;

/*
 * solve Chapter 14: check 2 strings are anagrams
 * algo: 
 * method1: sort and compare
 * method2(used): use bucket array to count the character:
 * 			O(n) iterate through string 1 and + 1 to bucket[int(char)]
 * 			O(m) iterate through string 2 and do - 1 for each bin
 * 			if all bins are 0 then 2 strings are anagrams
 */

public class Chap14 extends Chapter {
	
	@Override
	public void run() {
		boolean ana = isAna(DataFeeder.getAnaString1(), DataFeeder.getAnaString2());
		System.out.println("2 strings are anagram ?" + String.valueOf(ana));
		ana = isAna(DataFeeder.getAnaString1(), DataFeeder.getAnaString3());
		System.out.println("2 strings are anagram ?" + String.valueOf(ana));
	}

	private boolean isAna(String str1, String str2) {
		
		if (str1 == null || str2 == null) return false;
		if (str1.length() != str2.length()) return false;
		
		boolean isAna = true;
		int size = 256;
		int[] buckets = new int[size];
		
		for (char c1 : str1.toCharArray()) {
			buckets[(int)c1]++;
		}
		
		for (char c2 : str2.toCharArray()) {
			buckets[(int)c2]--;
		}
		
		//check 
		for (int i : buckets) {
			if (i != 0) {
				isAna = false;
				break;
			}
		}
		
		return isAna;
	}
}
