package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * Note: Duplicate elements are allowed. insert(val): Inserts an item val to the
 * collection. remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The
 * probability of each element being returned is linearly related to the number
 * of same value the collection contains. Example:
 * 
 * // Init an empty collection. RandomizedCollection collection = new
 * RandomizedCollection();
 * 
 * // Inserts 1 to the collection. Returns true as the collection did not
 * contain 1. collection.insert(1);
 * 
 * // Inserts another 1 to the collection. Returns false as the collection
 * contained 1. Collection now contains [1,1]. collection.insert(1);
 * 
 * // Inserts 2 to the collection, returns true. Collection now contains
 * [1,1,2]. collection.insert(2);
 * 
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the
 * probability 1/3. collection.getRandom();
 * 
 * // Removes 1 from the collection, returns true. Collection now contains
 * [1,2]. collection.remove(1);
 * 
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 * 
 * @author skadavath
 *
 */
public class InsertDeleteGetRandomO1DuplicatesAllowed {
	
	public static void main(String[] args) {
		InsertDeleteGetRandomO1DuplicatesAllowed insDel = new InsertDeleteGetRandomO1DuplicatesAllowed();
		System.out.println(insDel.insert(1));
		System.out.println(insDel.insert(1));
		System.out.println(insDel.insert(2));
		System.out.println(insDel.insert(2));
		System.out.println(insDel.insert(3));
		System.out.println(insDel.remove(1));
	}

	Map<Integer, LinkedHashSet<Integer>> map = new HashMap<>();
	List<Integer> list = new ArrayList<>();
	
	Random rnd = new Random();

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {

		boolean contains = map.containsKey(val);

		if (!contains) {
			map.put(val, new LinkedHashSet<>());
		}
		map.get(val).add(list.size());
		list.add(val);
		return !contains;

	}

	/**
	 * Removes a value from the collection. Returns true if the collection contained
	 * the specified element.
	 */
	public boolean remove(int val) {

		boolean contains = map.containsKey(val);
		
		if(!contains)return false;
		LinkedHashSet<Integer> currSet = map.get(val);
		// getting the first element since it will be the last
		int currLoc = currSet.iterator().next();
		map.get(val).remove(currLoc);
		if (currLoc < list.size() - 1) {

			int lastOne = list.get(list.size() - 1);
			list.set(currLoc, lastOne);
			
			map.get(lastOne).remove(list.size()-1);
			map.get(lastOne).add(currLoc);
		}
		list.remove(list.size()-1);
		if(map.get(val).isEmpty())
			map.remove(val);
		
		return true;

	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return list.get(rnd.nextInt(list.size()));
	}

}
