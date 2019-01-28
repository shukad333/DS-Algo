package com.general.geeks.tree;

import java.util.Stack;

/**
 * 
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:

Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: "1,#"
Output: false
Example 3:

Input: "9,#,#,1"
Output: false

 * 
 * @author skadavath
 *
 */
public class VerifyPreorderSeializationOfBinaryTree {
	
	public static void main(String[] args) {
		
		System.out.println(new VerifyPreorderSeializationOfBinaryTree().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		
	}

	public boolean isValidSerialization(String preorder) {
		
		// using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
		
		String[] pre = preorder.split(",");
		
		Stack<String> stack = new Stack<>();
		
		for(int i=0;i<pre.length;i++) {
			String curr = pre[i];
			while(curr.equals("#") && !stack.isEmpty() && stack.peek().equals(curr)) {
				
				stack.pop();
				if(stack.isEmpty())
					return false;
				
				stack.pop();
				
			}
			
			stack.push(curr);
		}
		
		return stack.size()==1 && stack.peek().equals("#");

	}

}
