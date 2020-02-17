package com.general.geeks.tree;

/**
 * 
 * We run a preorder depth first search on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)

If a node has only one child, that child is guaranteed to be the left child.

Given the output S of this traversal, recover the tree and return its root.

 

Example 1:



Input: "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]
Example 2:



Input: "1-2--3---4-5--6---7"
Output: [1,2,5,3,null,6,null,4,null,7]
 

Example 3:



Input: "1-401--349---90--88"
Output: [1,401,null,349,88,90]
 

Note:

The number of nodes in the original tree is between 1 and 1000. 
Each node will have a value between 1 and 10^9.
 * 
 * @author skadavath
 *
 */
public class RecoverATreeFromPreOrderTraversal {
	
	int index = 0;
	public TreeNode recoverFromPreorder(String S) {
		
		return constructTree(S, 0);
	}
	
	
	private TreeNode constructTree(String S , int depth) {
		
		int dashes = 0;
		
		while(index+dashes<S.length() && S.charAt(index+dashes)=='-')
			dashes++;
		
		if(dashes!=depth)
			return null;
		
		//calculate the number
		
		int next = index+dashes;
		
		while(next<S.length() && S.charAt(next)!='-')
			next++;
		int nodeVal = Integer.parseInt(S.substring(index+dashes, next));
		
		index = next;
		
		TreeNode node = new TreeNode(nodeVal);
		node.left = constructTree(S, depth+1);
		node.right = constructTree(S, depth+1);
		
		return node;
		
	}

}
