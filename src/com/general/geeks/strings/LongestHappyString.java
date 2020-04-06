package com.general.geeks.strings;

/**
 *
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.
 *
 * Given three integers a, b and c, return any string s, which satisfies following conditions:
 *
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * If there is no such string s return the empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 2, b = 2, c = 1
 * Output: "aabbc"
 * Example 3:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It's the only correct answer in this case.
 *
 *
 * Constraints:
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 */
public class LongestHappyString {

    public static void main(String[] args) {

        System.out.println(new LongestHappyString().longestDiverseString(1,1,7));

    }

    public String longestDiverseString(int a, int b, int c) {

        return longest(a,b,c,"a","b","c");


    }


    private String longest(int a , int b , int c , String aa,String bb,String cc) {

        if(a<b)
            return longest(b,a,c,bb,aa,cc);

        if(b<c)
            return longest(a,c,b,aa,cc,bb);

        if(b==0)
            return aa.repeat(Math.min(2,a));

        int use_a = Math.min(2,a),use_b=a-use_a>=b?1:0;
        return aa.repeat(use_a) + bb.repeat(use_b) + longest(a-use_a,b-use_b,c,aa,bb,cc);

    }
}
