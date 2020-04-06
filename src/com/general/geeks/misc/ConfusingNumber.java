package com.general.geeks.misc;

public class ConfusingNumber {


    public static void main(String[] args) {

        System.out.println(new ConfusingNumber().confusingNumberII(20));

    }

    private int count = 0;
    private int n = 0;

    public int confusingNumberII(int N) {
        n = N;
        search(0);
        return count;
    }

    private void search(long num) {
        if (num > n) return;
        if (num != 0) {
            if (rotate(num) != num) ++count;
        }
        if (num != 0) search(num * 10);
        search(num * 10 + 1);
        search(num * 10 + 6);
        search(num * 10 + 8);
        search(num * 10 + 9);
    }

    private long rotate(long x) {
        long y = 0;
        for (; x != 0; x /= 10) {
            int k = (int) (x % 10);
            switch (k) {
                case 6:
                    k = 9;
                    break;
                case 9:
                    k = 6;
                    break;
            }
            y = y * 10 + k;
        }
        return y;
    }
}
