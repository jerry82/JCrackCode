package chap1.arraystring;


import main.*;
import util.*;

/*
 * solve Chapter 1.2: reverse a string
 * algo: in place reverse is easy
 */
public class Chap12 extends Chapter {
	@Override
	public void run() {
		String str = DataFeeder.getUniqueCharacterString();
		reverse(str);
	}
	
	private void reverse(String str) {
		
		if (str != null && !str.isEmpty()) {
			
			char[] chars = str.toCharArray();
			int mid = chars.length / 2;
			int l = chars.length - 1;
			
			for (int i = 0; i < mid; i++) {
				char tmp = chars[i];
				chars[i] = chars[l - i];
				chars[l - i] = tmp;
			}
			
			System.out.format("before: %s\n", str);
			System.out.format("reverse: %s\n", String.valueOf(chars));
		}
	}
}
