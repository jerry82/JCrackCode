package chap5.bit;

import main.*;

/*
 * 
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j Write a 
	method to set all bits between i and j in N equal to M (e g , M becomes a substring of 
	N located at i and starting at j) 
	EXAMPLE:
	Input: N = 10000000000, M = 10101, i = 2, j = 6
	Output: N = 10001010100
	
	Alg: 
	things to be noted: 
	1 << 2 = 100
	1 << 2 - 1 = 11
 */

public class Chap51 extends Chapter {
	@Override
	public void run() {
		int i = 2, j = 6;
		int N = 1025, M = 21;
		System.out.println(getOutput(N, M, i, j));
	}
	
	private String getOutput(int N, int M, int i, int j) {
		String tmp = "";
		
		int max = Integer.MAX_VALUE;
		
		System.out.println(Integer.toBinaryString(M));
		System.out.println(Integer.toBinaryString(N));
		
		int left = max - ((1 << j) - 1);
		System.out.println(Integer.toBinaryString(left));
		int right = ((1 << i) - 1);
		System.out.println(Integer.toBinaryString(right));
		
		int mask = left | right;
		System.out.println(Integer.toBinaryString(mask));

		int output = (N & mask) | (M << i);
		tmp = Integer.toBinaryString(output);
		
		return tmp;
	}
}
