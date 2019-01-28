package com.general.geeks.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * Example:
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class RepeatedDNASequence {

	public static void main(String[] args) {

		System.out.println(new RepeatedDNASequence().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

	}

	public List<String> findRepeatedDnaSequences(String s) {

		Set<String> visited = new HashSet<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i + 9 < s.length(); i++) {

			String subStr = s.substring(i, i + 10);
			if (!visited.add(subStr)) {
				set.add(subStr);
			}

		}

		return new ArrayList<>(set);

	}

}
