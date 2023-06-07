package com.general.geeks.array;

public class FirstLastOcc {

    public static void main(String[] args) {

        int[] arr = {1,1,2,3,4,4,4,4,4,4,4,4,7,8,9,9,9,9};
//        System.out.println(first(arr,4));
//        System.out.println(last(arr,4));

        String s = "abcdefabc",ss = "abc";

        System.out.println(s.startsWith(ss,7));
    }



    static int last(int[] arr , int t) {
        int l=0,r=arr.length-1;
        while(l<=r) {
            int mid = (l+r)>>1;
            if(mid==arr.length-1 || mid<arr.length-1 && arr[mid]==t && arr[mid+1]>t)
                return mid;
            if(arr[mid]>t)
                r = mid;
            else
                l = mid+1;

        }

        return l;
    }

    static int first(int[] arr , int t) {
        int l=0,r=arr.length-1;
        while(l<r) {
            int mid = (l+r)>>1;
            if(arr[mid]<t)
                l = mid+1;
            else
                r = mid;

        }

        return l;
    }

}
