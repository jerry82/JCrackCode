package chap1.arraystring;

import main.*;
import util.*;

/*
 * solve Chapter 1.8: given isSubstring method, check whether s1 is rotatedstring of s2 using 
 * only isSubstring
 * i.e: "waterbottle" and "erbottlewat"
 * algo: check whether s2 is substring of s1 + s1 AND s1 is substring of s2 + s2
 * MUST satisfy 2 conditions
 * 
 */
public class Chap18 extends Chapter {
	@Override
	public void run() {
		String s1 = DataFeeder.getRotatedString1();
		String s2 = DataFeeder.getRotatedString2();
		
		System.out.format("%s", isSubstring(s2, s1 + s1) && isSubstring(s1, s2 + s2));
	}
	
	
	//check if s1 is substring of s2
	private boolean isSubstring(String s1, String s2) {
		boolean isSub = true;
	
		if (s1 == null || s2 == null) return false;
		if (s1.length() > s2.length()) return false;
		
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		
		int i1 = 0;
		
		for (int i = 0; i < chars2.length; i++) {
			while (chars1[i1] == chars2[i]) {
				i1++;
				i++;
				if (i1 >= chars1.length) {
					break;
				}
				
				if (i >= chars2.length) {
					return false;
				}
			}
			
			if (i1 == chars1.length) 
				return true;
			else {
				i1 = 0;
			}
		}
		
		return isSub; 
	}
}
