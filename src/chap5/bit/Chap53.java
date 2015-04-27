package chap5.bit;

import main.*;
/*
 * Given an integer, print the next smallest and next largest number that have the same 
number of 1 bits in their binary representation
 i.e: 001011100 
 -> next smallest but > 001011100: 001011100->001101100 -> 001100011
 right to left, if pass 1, turn on next 0->1, and 1->0 on the right side of that...rest of 1s move to end 
 -> next largest < 101000011: 101000011 -> 100100011 -> 100111000 
 right to left, if pass 0, turn 10xxx -> 01xxx, move all 1 from xxx to the left
 */
public class Chap53 extends Chapter {
	@Override
	public void run() {
		int N = Integer.parseInt("001011100", 2);
		getSmallest(N);
		
		N = Integer.parseInt("111000011", 2);
		getLargest(N);
	}
	
	private void getSmallest(int N) {
		
		System.out.println("smallest of:\n" + Integer.toBinaryString(N));
		
		int noOf1 = 0;
		boolean foundOne = false;
		int i = 0;
		while (i < 32) {
			if (((N >> i) & 1) == 1) {
				foundOne = true;
				noOf1++;
			}
			
			if (foundOne) {
				if (((N >> i) & 1) == 0) {
					break;
				}
			}
			
			i++;
		}
		int val = 1 << i;
		
		//no of 1 left after turn 0 - 1 to make the number bigger is noOf1 - 1 
		//move noOf1 to the right
		int right = (1 << (noOf1 -1)) - 1;
		//turn off all bits from the right of largest bit 1:
		N = (N >> i) << i;
		int result = N | val | right;
		System.out.println(Integer.toBinaryString(result));
	}
	
	private void getLargest(int N) {
		System.out.println("the biggest of: \n" + Integer.toBinaryString(N));
		
		int noOf1 = 0;
		boolean found0 = false;
		int i = 1;
		while (i < 32) {
			if (((N >> i) & 1) == 0) {
				found0 = true;
			}
			else {
				noOf1++;
			}
			
			if (found0) {
				if (((N >> i) & 1) == 1) {
					break;
				}	
			}
			
			i++;
		}
		
		//set all 0s on the left
		N = N >> (i + 1) << (i + 1);
		N = N | (1 << (i - 1));
		
		//move noOf1s to the left;
		int right = (1 << noOf1) - 1;
		right = right << (i - 1 - noOf1);
		int result = N | right;
		System.out.println(Integer.toBinaryString(result));
		
	}
}
