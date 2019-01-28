package com.general.geeks.bst;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

 * @author skadavath
 *
 */
public class ConstructTreeFromBinaryTree {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(4);
		node.right = new TreeNode(3);
		System.out.println(new ConstructTreeFromBinaryTree().tree2str(node));
	}
	public String tree2str(TreeNode t) {
		
		 if (t == null) return "";
	        
	        String result = t.data + "";
	        
	        String left = tree2str(t.left);
	        String right = tree2str(t.right);
	        
	        if (left == "" && right == "") return result;
	        if (left == "") return result + "()" + "(" + right + ")";
	        if (right == "") return result + "(" + left + ")";
	        return result + "(" + left + ")" + "(" + right + ")";
	}
	
	

}
