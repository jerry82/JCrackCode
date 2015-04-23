package chap1.arraystring;

import main.*;
import util.*;
/*
 * solve chapter 1.1: 
 * Check string if includes all unique char (* not using additional data structure)
 * algo: use bucket sort, bucket size is large enof to store all ASCII values presuming the 
 * ASCII size is 1 byte 
 */
public class Chap11 extends Chapter {

	@Override
	public void run() {
		String str1 = DataFeeder.getUniqueCharacterString();
		analyze(str1);
		
		String str2 = DataFeeder.getNotUniueCharacterString();
		analyze(str2);
	}
	
	private void analyze(String str) {
		boolean uniq = checkUniqeChar(str);
		String display = uniq ? "UNIQUE" : "NOT UNIQUE";
		System.out.format("%s is: %s\n", str, display);
	}
	
	private boolean checkUniqeChar(String input) {
		boolean success = true;
		int size = 256; // 1byte to represent all ASCII character
		int[] buckets = new int[size]; 
		
		for (char i : input.toCharArray()) {
			int id = (int)i;
			if (buckets[id] == 0) {
				buckets[id]++;
			}
			else {
				success = false;
				break;
			}
		}
		
		return success;
	}
}
