package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array of digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order.
 * <p>
 * Since the answer may not fit in an integer data type, return the answer as a string.
 * <p>
 * If there is no answer return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [8,1,9]
 * Output: "981"
 * Example 2:
 * <p>
 * Input: digits = [8,6,7,1,0]
 * Output: "8760"
 * Example 3:
 * <p>
 * Input: digits = [1]
 * Output: ""
 * Example 4:
 * <p>
 * Input: digits = [0,0,0,0,0,0]
 * Output: "0"
 */
public class LargestMultipleOf3 {

    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        List<Integer> remain1Indices = new ArrayList<>(2); // Indices of up to 2 elements with remainder = 1
        List<Integer> remain2Indices = new ArrayList<>(2); // Indices of up to 2 elements with remainder = 2
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 3 == 1 && remain1Indices.size() < 2) remain1Indices.add(i);
            else if (digits[i] % 3 == 2 && remain2Indices.size() < 2) remain2Indices.add(i);
        }
        int remainSum = Arrays.stream(digits).sum() % 3;
        if (remainSum == 1) { // Delete 1 smallest digit with remainder = 1 or Delete 2 smallest digits the remainder = 2
            if (remain1Indices.size() >= 1) return getResult(digits, remain1Indices.get(0), -1);
            else return getResult(digits, remain2Indices.get(0), remain2Indices.get(1));
        } else if (remainSum == 2) { // Delete 1 smallest digit with remainder = 2 or Delete 2 smallest digits with remainder = 1
            if (remain2Indices.size() >= 1) return getResult(digits, remain2Indices.get(0), -1);
            else return getResult(digits, remain1Indices.get(0), remain1Indices.get(1));
        }
        return getResult(digits, -1, -1);
    }
    private String getResult(int[] digits, int ban1, int ban2) {
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == ban1 || i == ban2) continue; // Skip banned digits
            sb.append(digits[i]);
        }
        if (sb.length() > 0 && sb.charAt(0) == '0') return "0"; // Remove leading 0 case [0,...,0]
        return sb.toString();
    }
}
