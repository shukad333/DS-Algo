package com.designpatterns.dp.design;


import java.io.*;
import java.util.*;

public class Main {

    static int n,a,b;
    static char s[];
    static int dp[];
    static SA S;
    static Rmq rmq, rmq2;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();
        while(t-- > 0){
            n = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();
            s = in.readString().toCharArray();

            S = new SA(s);
            S.buildSA();
            S.buildLCP();

            //System.out.println(Arrays.toString(S.sa));
            //System.out.println(Arrays.toString(S.lcp));

            rmq = new Rmq(S.sa);
            rmq2 = new Rmq(S.lcp);

            dp = new int[n + 1];
            dp[n] = 0;
            int[] max= new int[n];
            for(int i=0;i<n;i++)
                max[i] = search(i);
            for(int i = n - 1; i >= 0; i--){
                dp[i] = a + dp[i + 1];
                if(max[i] > 0)
                    dp[i] = Math.min(dp[i], b + dp[i + max[i]]);
            }

            w.println(dp[0]);
        }
        w.close();
    }
    static int search(int i){
        int max=0;
        int start = 0, end = Math.min(i, n - i) + 1;

        while(start < end){
            int mid = (start + end);
            int rank = S.rank[i];
            int maxNow = 0;
            mid/=2;
            if(rank > 0){
                int ans = right_search(0, rank - 1, i - mid);
                if(ans != -1)
                    maxNow = Math.max(maxNow, rmq2.minPos(ans, rank - 1));

            }

            if(rank + 1 < n){
                int ans1 = left_search(rank + 1, n - 1, i - mid);
                if(ans1 != -1){
                    maxNow = Math.max(maxNow, rmq2.minPos(rank, ans1 - 1));
                }
            }

            if(maxNow >= mid){
                max = mid;
                start = mid + 1;
            }

            else
                end = mid;
        }

        return max;
    }
    static public int right_search(int start, int end, int x){

        while(start!=end){
            int mid = (start + end) >> 1;
            if(rmq.minPos(mid + 1, end) <= x)
                start=mid+1;
            else
                end=mid;
        }
        if(S.sa[start] > x)	return -1;
        return start;
    }

    static public int left_search(int start, int end, int x){
        if(start == end)	{
            if(S.sa[start] > x)	return -1;
            return start;
        }
        int mid = (start + end) >> 1;
        if(rmq.minPos(start, mid) <= x)
            return left_search(start, mid, x);
        else
            return left_search(mid + 1 , end , x);
    }

    static public class SA{

        int n;
        char s[];
        int sa[],rank[],lcp[];

        SA(char o[]){
            n = o.length;
            s = new char[n];
            for(int i = 0; i < n; i++)
                s[i] = o[i];
        }

        public void buildSA() {
            Integer[] order = new Integer[n];
            for (int i = 0; i < n; i++)
                order[i] = n - 1 - i;

            Arrays.sort(order, new myComp());

            sa = new int[n];
            int[] classes = new int[n];
            for (int i = 0; i < n; i++) {
                sa[i] = order[i];
                classes[i] = s[i];
            }

            for (int len = 1; len < n; len *= 2) {
                int[] c = classes.clone();
                for (int i = 0; i < n; i++)
                    classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]]
                            && sa[i - 1] + len < n
                            && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]] : i;

                int[] cnt = new int[n];
                for (int i = 0; i < n; i++)
                    cnt[i] = i;

                int[] s = sa.clone();
                for (int i = 0; i < n; i++) {
                    int s1 = s[i] - len;
                    if (s1 >= 0)
                        sa[cnt[classes[s1]]++] = s1;
                }
            }

        }

        public void buildLCP() {
            rank = new int[n];
            for (int i = 0; i < n; i++)
                rank[sa[i]] = i;

            lcp = new int[n];

            for (int i = 0, h = 0; i < n; i++) {
                if (rank[i] < n - 1) {
                    for (int j = sa[rank[i] + 1]; Math.max(i, j) + h < n && s[i + h] == s[j + h]; ++h)
                        ;
                    lcp[rank[i]] = h;
                    if (h > 0)
                        --h;
                }
            }
        }


        public class myComp implements Comparator<Integer>{
            public int compare(Integer a,Integer b){
                return Character.compare(s[a],s[b]);
            }
        }

    }

    static public class Rmq {

        int[] logTable;
        int[][] rmq;
        int[] a;

        public Rmq(int[] a) {
            this.a = a;
            int n = a.length;

            logTable = new int[n + 1];
            for (int i = 2; i <= n; i++)
                logTable[i] = logTable[i >> 1] + 1;

            rmq = new int[logTable[n] + 1][n];

            for (int i = 0; i < n; ++i)
                rmq[0][i] = i;

            for (int k = 1; (1 << k) < n; ++k) {
                for (int i = 0; i + (1 << k) <= n; i++) {
                    int x = rmq[k - 1][i];
                    int y = rmq[k - 1][i + (1 << k - 1)];
                    rmq[k][i] = a[x] <= a[y] ? x : y;
                }
            }
        }

        public int minPos(int i, int j) {
            int k = logTable[j - i];
            int x = rmq[k][i];
            int y = rmq[k][j - (1 << k) + 1];
            return a[x] <= a[y] ? a[x] : a[y];
        }

    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}