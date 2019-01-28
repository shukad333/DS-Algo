package com.general.geeks.misc;

/**
 * Given a non-empty array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,3,2] Output: 3 Example 2:
 * 
 * Input: [0,1,0,1,0,1,99] Output: 99
 * 
 * @author skadavath
 *
 */
public class SingleNumber2 {
	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(~1));
	}

	/*
    This is a case of a finite state machine.
    States of machine- Total three (number appeared once, number appeared twice, number appeared thrice)
    Action - Incoming bit of one
    We will need two bits to keep track of the state. So lets take those states as 00, 01 and 10.
    The states will transition like 00 -> 01 -> 10 with every incoming bit.
    Now lets look at the individual bits.
    First bit - 0 -> 0 -> 1 -> back to 0
    Second bit - 0 -> 1 -> 0 -> back to 0
    Note that these bits are transitioning with every state change. Now we need to find a pattern of this change.

    For first bit it is sufficient to say that with every incoming 1 bit, its next state is its XOR with it with an exception-
    If second bit is set, the first bit becomes zero. So we come up with =>
    ones = ones ^ A[i];
    if (twos == 1) then ones = 0
    It condenses to (ones ^ A[i]) & ~twos;

    For second bit, it is sufficient to say that with every incoming 1 bit, its next state is its XOR with it with an exception-
    If the one's bit after the change above is set, then it will become zero too. So we come up with =>
    twos = twos ^ A[i];
    if (ones* == 1) then twos = 0
    It condenses to (twos ^ A[i]) & ~ones;
     */
    public static int singleNumber5(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){

            // Accumulate the incoming number in ones provided twos is zero.
            // Twos will hold the number that has appeared twice.
            // If two becomes zero, it means the number has appeared the third time- Ones will hold that number now
            ones = (ones ^ A[i]) & ~twos;

            // Wait for ones bits to be zero before you increment twos.
            // Ones will be zero when the number is received twice.
            // So when the number will be received twice, we will store that in twos.
            twos = (twos ^ A[i]) & ~ones;
        }

        return ones;
    }

}
