package com.general.geeks.bst;

import java.util.LinkedList;
import java.util.Queue;

import jdk.nashorn.internal.ir.Node;

/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

Example 2:
Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
Note:
The given d is in range [1, maximum depth of the given tree + 1].
The given binary tree has at least one tree node.
 * @author skadavath
 *
 */
public class AddOneRowToTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.right = new TreeNode(6);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(1);
		node.right.left = new TreeNode(5);
		
		TreeNode res = new AddOneRowToTree().addOneRow(node, 1, 2);
		
		
		new AddOneRowToTree().printPre(res);
		
		
	}
	
	private void printPre(TreeNode node) {
		if(null==node)
			return;
		System.out.println(node.data);
		printPre(node.left);
		printPre(node.right);
	}

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		
		if(d==1) {
			TreeNode tmp = new TreeNode(v);
			tmp.left = root;
			return tmp;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		for(int i=0;i<d-2;i++) {
			
			int size = queue.size();
			while(size-->0) {
				TreeNode poll = queue.poll();
				TreeNode left = poll.left;
				TreeNode right = poll.right;
				if(left!=null)
					queue.add(left);
				if(right!=null)
					queue.add(right);
			}
		}
		
		
		while(!queue.isEmpty()) {
			
			TreeNode t = queue.poll();
			TreeNode tmp = t.left;
			t.left = new TreeNode(v);
			t.left.left = tmp;
			tmp = t.right;
			t.right = new TreeNode(v);
			t.right.right = tmp;
		}
		
		return root;

	}

}
