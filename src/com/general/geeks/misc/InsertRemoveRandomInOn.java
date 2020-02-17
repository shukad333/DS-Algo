package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present. getRandom: Returns
 * a random element from current set of elements. Each element must have the
 * same probability of being returned. Example:
 * 
 * // Init an empty set. RandomizedSet randomSet = new RandomizedSet();
 * 
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * 
 * // Returns false as 2 does not exist in the set. randomSet.remove(2);
 * 
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * 
 * // getRandom should return either 1 or 2 randomly. randomSet.getRandom();
 * 
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * 
 * // 2 was already in the set, so return false. randomSet.insert(2);
 * 
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * 
 * @author skadavath
 *
 */
public class InsertRemoveRandomInOn {
	
	public static void main(String[] args) {
		InsertRemoveRandomInOn in = new InsertRemoveRandomInOn();
		
		System.out.println(in.insert(12));
		System.out.println(in.insert(13));
		System.out.println(in.insert(13));
		System.out.println(in.insert(13));
		System.out.println(in.insert(4));
		System.out.println(in.insert(1));
		System.out.println(in.remove(4));
		System.out.println(in.getRandom());
		System.out.println(in.getRandom());
	}

	Map<Integer, Integer> map = new HashMap<>();
	List<Integer> list = new ArrayList<>();
	
	Random rnd = new Random();

	/** Initialize your data structure here. */
	public InsertRemoveRandomInOn() {

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {

		if (map.containsKey(val))
			return false;
		map.put(val, map.size());
		list.add(val);
		return true;
	}


	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if(!map.containsKey(val)) {
			return false; 
		}
		
		
		Integer key = map.get(val);
		//not last , so swap with last
		if(key<list.size()-1) {
			int last = list.get(list.size()-1);
			list.set(key, last);
			map.put(last, key);
		}
		map.remove(val);
		list.remove(list.size()-1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		
		return list.get(rnd.nextInt(list.size()));
	}
}