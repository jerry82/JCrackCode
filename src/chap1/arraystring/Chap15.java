package chap1.arraystring;

import java.util.*;

import main.*;
import util.*;

/* 
 * solve Chapter 1.5: replace all spaces in the string with %20
 * algo: it should be easy
 * using string builder
 */

public class Chap15 extends Chapter {
	
	@Override
	public void run() {
		replace(DataFeeder.getStringWithSpaces());
	}
	
	private void replace(String input) {
		if (input == null) return;
		if (input.length() == 0) return;
		
		System.out.format("before: %s\n", input);
		
		StringBuilder sb = new StringBuilder();
		
		for (char c : input.toCharArray()) {
			if (c != ' ') {
				sb.append(c);
			}
			else {
				sb.append("%20");
			}
		}
		input = sb.toString();
		System.out.format("after: %s\n", input);
	}
}
