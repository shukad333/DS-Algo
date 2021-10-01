package com.geeks.hackerrank;

public class ShortPallindrome {

    public static int shortPalindrome(String s) {
        // Write your code here


        int[] freq = new int[26];
        int[][] pairfreq = new int[26][26];
        int[] tripfreq = new int[26];
        final int CONSTANT = 1000000000+7;
        int ans = 0;
        for(char c:s.toCharArray()){
            ans = (ans+tripfreq[c-'a'])%CONSTANT;
            for(int i=0; i<26; i++){
                tripfreq[i] = (tripfreq[i] + pairfreq[i][c-'a'])%CONSTANT;
            }
            for(int i=0; i<26; i++){
                pairfreq[i][c-'a'] = (pairfreq[i][c-'a'] + freq[i])%CONSTANT;
            }
            freq[c-'a']++;
        }
        System.out.println(ans);
        return ans;
    }

}
