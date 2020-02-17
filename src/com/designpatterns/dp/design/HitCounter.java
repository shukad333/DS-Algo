package com.designpatterns.dp.design;

public class HitCounter {
	
	public static void main(String[] args) {
		
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(2);
		counter.hit(3);
		counter.hit(30);
		counter.hit(31);
		System.out.println(counter.getHits(301));
		
	}
	
	private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }

}
