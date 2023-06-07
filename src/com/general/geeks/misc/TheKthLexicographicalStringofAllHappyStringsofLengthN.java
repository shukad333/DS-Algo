package com.general.geeks.misc;

public class TheKthLexicographicalStringofAllHappyStringsofLengthN {

    public static void main(String[] args) {

//        String resp = new TheKthLexicographicalStringofAllHappyStringsofLengthN().getHappyString(3,9);
        String resp = new TheKthLexicographicalStringofAllHappyStringsofLengthN()._getHappy(3,9,0,' ');
        System.out.println(resp);

    }

    private String _getHappy(int n , int k,int p,char prev) {
        if(p==n)
            k--;
        else {
            for(char c = 'a';c<='c';c++) {
                if(c!=prev) {
                    String resp = _getHappy(n,k,p+1,c);
                    if(k==0)
                        return c+resp;
                }
            }
        }
        return "";
    }

    public String getHappyString(int n, int k) {
        int prem = 1 << (n - 1);
        if (k > 3 * prem)
            return "";
        int ch = 'a' + (k - 1) / prem;
        StringBuilder sb = new StringBuilder(Character.toString(ch));
        while (prem > 1) {
            k = (k - 1) % prem + 1;
            prem >>= 1;
            ch = (k - 1) / prem == 0 ? 'a' + (ch == 'a' ? 1 : 0) : 'b' + (ch != 'c' ? 1 : 0);
            sb.append((char)ch);
        }
        return sb.toString();
    }
}
