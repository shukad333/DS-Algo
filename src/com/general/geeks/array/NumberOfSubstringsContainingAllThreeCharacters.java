package com.general.geeks.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 *
 */
public class NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        l.add(100);

        System.out.println(new NumberOfSubstringsContainingAllThreeCharacters().numberOfSubstrings("abca"));

    }

    public int numberOfSubstrings(String s) {

        int[] count = {0,0,0};
        int resp=0,j=0;

        for(int i=0;i<s.length();i++) {

            ++count[s.charAt(i)-'a'];

            while(count[0]>0 && count[1]>0 && count[2]>0) {
                --count[s.charAt(j++)-'a'];
            }
            resp += j;
        }

        return resp;
    }

    public int _numberOfSubstrings(String s) {

        int l1=-1,l2=-1,l3=-1,resp=0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='a')l1=i;
            else if(s.charAt(i)=='b')l2=i;
            else l3=i;

            int min = Math.min(l1,Math.min(l2,l3));

            resp+=min+1;
        }

        return resp;


    }
}
