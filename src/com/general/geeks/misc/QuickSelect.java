package com.general.geeks.misc;

public class QuickSelect {

    public static void main(String[] args) {

        int[] arr = {7,10,4,3,20,15};
        System.out.println(new QuickSelect().kthSmallest(arr,0,arr.length-1,3));

    }

    public  int kthSmallest(int[] arr, int low,
                                  int high, int k)
    {
        // find the partition
        int partition = partition(arr, low, high);

        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == k - 1)
            return arr[partition];

            // if partition value is less than kth position,
            // search right side of the array.
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);

            // if partition value is more than kth position,
            // search left side of the array.
        else
            return kthSmallest(arr, low, partition - 1, k);
    }

    private int partition(int[] arr , int low , int high) {
        int loc = low,pivot = arr[high];

        for(int i=low;i<=high;i++) {
            if(arr[i]<pivot) {
                swap(arr,i,loc);
                loc++;
            }
        }

        swap(arr,high,loc);
        return loc;
    }


    private void swap(int[] arr , int a , int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
