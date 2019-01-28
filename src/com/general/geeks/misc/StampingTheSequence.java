package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * You want to form a target string of lowercase letters.
 * 
 * At the beginning, your sequence is target.length '?' marks. You also have a
 * stamp of lowercase letters.
 * 
 * On each turn, you may place the stamp over the sequence, and replace every
 * letter in the sequence with the corresponding letter from the stamp. You can
 * make up to 10 * target.length turns.
 * 
 * For example, if the initial sequence is "?????", and your stamp is "abc",
 * then you may make "abc??", "?abc?", "??abc" in the first turn. (Note that the
 * stamp must be fully contained in the boundaries of the sequence in order to
 * stamp.)
 * 
 * If the sequence is possible to stamp, then return an array of the index of
 * the left-most letter being stamped at each turn. If the sequence is not
 * possible to stamp, return an empty array.
 * 
 * For example, if the sequence is "ababc", and the stamp is "abc", then we
 * could return the answer [0, 2], corresponding to the moves "?????" -> "abc??"
 * -> "ababc".
 * 
 * Also, if the sequence is possible to stamp, it is guaranteed it is possible
 * to stamp within 10 * target.length moves. Any answers specifying more than
 * this number of moves will not be accepted.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: stamp = "abc", target = "ababc" Output: [0,2] ([1,0,2] would also be
 * accepted as an answer, as well as some other answers.) Example 2:
 * 
 * Input: stamp = "abca", target = "aabcaca" Output: [3,0,1]
 * 
 * @author skadavath
 *
 */
public class StampingTheSequence {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(new StampingTheSequence().movesToStamp("abca", "aabcaca")));

	}

	/**
	 * 
	 * for abca -> aabcaca replace abca with ???? 1. -> a????ca 2. -> ?????ca 3. ->
	 * ???????
	 * 
	 * So answer will be [1,0,3]
	 * 
	 * @param stamp
	 * @param target
	 * @return
	 */
	public int[] movesToStamp(String stamp, String target) {

		char[] targetArr = target.toCharArray();
		char[] stampArr = stamp.toCharArray();

		List<Integer> resp = new ArrayList<>();
		int wildCard = 0;
		boolean[] visited = new boolean[target.length()];
		while (wildCard < targetArr.length) {
			boolean doneReplace = false;
			for (int i = 0; i <= targetArr.length - stampArr.length; i++) {
				if (!visited[i] && doesPatternExist(stampArr, targetArr, i)) {
					wildCard += replaceStampWithWildCard(stampArr, targetArr, i);
					resp.add(i);
					visited[i] = true;
					doneReplace = true;
					if(wildCard==targetArr.length)
						break;
				}
				
			}
			if (!doneReplace)
				return new int[] {};
		}

		
		int[] resArray = new int[resp.size()];
        for (int i = 0; i < resp.size(); i++) {
            resArray[i] = resp.get(resp.size() - i - 1);
        }
        return resArray;

	}

	private boolean doesPatternExist(char[] stamp, char[] target, int index) {

		for(int i=0;i<stamp.length;i++) {
			if (stamp[i] != target[i+index] && target[i+index] != '?')
				return false;
			
		}
		return true;
	}

	private int replaceStampWithWildCard(char[] stamp, char[] target, int index) {

		int start = 0;
		for (int i = 0; i < stamp.length; i++) {
			if (target[i+index] != '?') {
				start++;
				target[i+index] = '?';
			}
		}
		return start;

	}

}
