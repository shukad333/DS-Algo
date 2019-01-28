package com.general.geeks.tree;

/**
 * Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 * @author skadavath
 *
 */
public class PopulatingNextRightPointers {

	public void connect(TreeLinkNode root) {

		TreeLinkNode start = root;

		while (null != start) {
			TreeLinkNode curr = start;
			while (null != curr) {
				if (null != curr.left)
					curr.left.next = curr.right;
				// see the tree above for below reasoning on node 2
				if (null != curr.right && null != curr.next)
					curr.right.next = curr.next.left;

				curr = curr.next;
			}
			start = start.left;
		}

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int
 * val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 */
