package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Input: [5,2,6,1] Output: [2,1,1,0] Explanation: To the right of 5 there are 2
 * smaller elements (2 and 1). To the right of 2 there is only 1 smaller element
 * (1). To the right of 6 there is 1 smaller element (1). To the right of 1
 * there is 0 smaller element.
 * 
 * 
 * @author skadavath
 *
 */
public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {

		System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(new int[] { 5, 2, 6, 1 }));

	}

	public List<Integer> countSmaller(int[] nums) {

		Integer[] resp = new Integer[nums.length];

		Node node = null;
		for (int i = nums.length - 1; i >= 0; i--) {

			node = insert(nums[i], node, resp, i, 0);
		}

		return Arrays.asList(resp);

	}
	
	/**
	 * 
	 * Every node will maintain a val sum recording the total of number on it's left bottom side, dup counts the duplication. For example, [3, 2, 2, 6, 1], from back to beginning,we would have:

                1(0, 1)
                     \
                     6(3, 1)
                     /
                   2(0, 2)
                       \
                        3(0, 1)
When we try to insert a number, the total number of smaller number would be adding dup and sum of the nodes where we turn right.
for example, if we insert 5, it should be inserted on the way down to the right of 3, the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4

if we insert 7, the right-turning nodes are 1(0,1), 6(3,1), so answer should be (0 + 1) + (3 + 1) = 5
	 * @param num
	 * @param node
	 * @param ans
	 * @param index
	 * @param preSum
	 * @return
	 */

	private Node insert(int num, Node node, Integer[] ans, int index, int preSum) {

		if (null == node) {
			node = new Node(num, 0);
			ans[index] = preSum;
		} else if (node.val == num) {
			node.duplicates++;
			ans[index] = preSum + node.smaller;
		} else if (node.val > num) {
			node.smaller++;
			node.left = insert(num, node.left, ans, index, preSum);
		} else
			node.right = insert(num, node.right, ans, index, preSum + node.smaller + node.duplicates);

		return node;

	}

}

class Node {

	Node left, right;
	int val, duplicates = 1, smaller;

	public Node(int val, int smaller) {
		this.val = val;
		this.smaller = smaller;
	}
}
