package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 * summarize the numbers seen so far as a list of disjoint intervals.
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6,
 * ..., then the summary will be:
 * 
 * [1, 1] 
 * [1, 1], [3, 3] 
 * [1, 1], [3, 3], [7, 7] 
 * [1, 3], [7, 7]
 *  [1, 3], [6, 7]
 * Follow up: What if there are lots of merges and the number of disjoint
 * intervals are small compared to the data stream's size?
 * 
 * @author skadavath
 *
 */
public class DataStreamAsDisjointIntervals {
	public static void main(String[] args) {
		
		DataStreamAsDisjointIntervals ds = new DataStreamAsDisjointIntervals();
		ds.addNum(1);
		ds.addNum(3);
		ds.addNum(7);
		ds.addNum(2);
		ds.addNum(6);
		ds.addNum(5);
		ds.addNum(50);
		
		System.out.println(ds.getIntervals());
		
	}
	
	TreeMap<Integer, Interval> map = new TreeMap<>();
	
	/**
	 * 
	 * there are no intervals - create one
	 * val is one of the interval - do nothing
	 * val is one away from interval - merge/modify
	 * val is more than one from all intervals - make an interval
	 * 
	 * @param val
	 */
	 public void addNum(int val) {
			
			if(map.containsKey(val))
				return;
			
			Integer l = map.lowerKey(val);
			Integer h = map.higherKey(val);
			
			if(null!=l && null!=h && map.get(l).end+1==val && h==val+1) {
				map.get(l).end = map.get(h).end;
				map.remove(h);
			}
			else if(null!=l && map.get(l).end+1>=val) {
				map.get(l).end = Math.max(val, map.get(l).end);
			}
			
			else if(null!=h && h==val+1) {
				map.put(val, new Interval(val,map.get(h).end));
	            map.remove(h);
			}
			else
				map.put(val, new Interval(val,val));

		}

	public List<Interval> getIntervals() {
		
		return new ArrayList<>( map.values());

	}

}
