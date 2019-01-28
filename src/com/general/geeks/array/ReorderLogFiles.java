package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * You have an array of logs. Each log is a space delimited string of words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier. Then,
 * either:
 * 
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits. We will call
 * these two varieties of logs letter-logs and digit-logs. It is guaranteed that
 * each log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties. The digit-logs should be put in their
 * original order.
 * 
 * Return the final order of the logs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * 
 * 
 * Note:
 * 
 * 0 <= logs.length <= 100 3 <= logs[i].length <= 100 logs[i] is guaranteed to
 * have an identifier, and a word after the identifier.
 * 
 * @author skadavath
 *
 */
public class ReorderLogFiles {

	public static void main(String[] args) {

		System.out.println(Arrays
				.toString(new ReorderLogFiles().reorderLogFiles(new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" })));

	}

	public String[] reorderLogFiles(String[] logs) {

		List<String> letterLogs = new ArrayList<>(logs.length);
		List<String> digitLogs = new ArrayList<>();

		for (String log : logs) {
			if (Character.isDigit(log.charAt(log.indexOf(' ') + 1))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}

		Collections.sort(letterLogs, (log1, log2) -> {
			int idx = log1.indexOf(' ');
			String id1 = log1.substring(0, idx);
			String msg1 = log1.substring(idx + 1);
			idx = log2.indexOf(' ');
			String id2 = log2.substring(0, idx);
			String msg2 = log2.substring(idx + 1);
			int res = msg1.compareTo(msg2);
			return res == 0 ? id1.compareTo(id2) : res;
		});

		letterLogs.addAll(digitLogs);

		return letterLogs.toArray(new String[0]);
	}

}
