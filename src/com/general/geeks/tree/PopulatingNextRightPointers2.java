package com.general.geeks.tree;

/**
 * 
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
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

 * 
 * @author skadavath
 *
 */
public class PopulatingNextRightPointers2 {
	
	public static void main(String[] args) {
		
		TreeLinkNode1 node = new TreeLinkNode1(1);
		node.left = new TreeLinkNode1(2);
		node.right = new TreeLinkNode1(3);
		
		node.left.left = new TreeLinkNode1(4);
		node.left.right = new TreeLinkNode1(5);
		
		node.right.right = new TreeLinkNode1(7);
		
		new PopulatingNextRightPointers2().connect(node);
		
		
	}
	
	//difference is left node or right node can also be null
	
	public void connect(TreeLinkNode1 root) {
		
		TreeLinkNode1 curr = root;
		TreeLinkNode1 head = null;
		TreeLinkNode1 pre = null;
		
		while(null!=curr) {
			
			while(null!=curr) {
				
				if(null!=curr.left) {
					if(null!=pre) {
						pre.next = curr.left;
					}
					else {
						head = curr.left;
					}
					pre = curr.left;
				}
				
				if(null!=curr.right) {
					if(null!=pre) {
						pre.next = curr.right;
					}
					else 
						head = curr.right;
					pre = curr.right;
				}
				curr = curr.next;
				
			}
			
			curr = head;
			head = null;
			pre = null;
			
		}
		
		
	}

}


   class TreeLinkNode1 {
      int val;
      TreeLinkNode1 left, right, next;
      TreeLinkNode1(int x) { val = x; }
  }
 
