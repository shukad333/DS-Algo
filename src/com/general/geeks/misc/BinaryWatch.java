package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * @author skadavath
 *
 */
public class BinaryWatch {
	
	public static void main(String[] args) {
		
		System.out.println(new BinaryWatch().readBinaryWatch(1));
		
	}
	
	public List<String> readBinaryWatch(int num) {
		
		ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
	}

}
