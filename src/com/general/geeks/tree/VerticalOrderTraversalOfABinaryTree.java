package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 
 Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
 * 
 * @author skadavath
 *
 */
public class VerticalOrderTraversalOfABinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(3709);
		node.left = new TreeNode(4465);
		node.right = new TreeNode(2668);
		
		System.out.println(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(node));
		
	}
	
public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Map<Integer,TreeMap<Integer,TreeSet<Integer>>> map = new TreeMap<>();
        helper(root,map,0,0);
        List<List<Integer>> resp = new ArrayList<>();
        for(TreeMap<Integer,TreeSet<Integer>> entry : map.values()) {
            resp.add(new ArrayList<>());
            for(TreeSet<Integer> val : entry.values()) {
                for(int i : val) {
                    resp.get(resp.size()-1).add(i);
                }
            }
        }
        
        return resp;
    }
    
    private void helper(TreeNode root ,Map<Integer,TreeMap<Integer,TreeSet<Integer>>> map,int x,int y) {
        
        if(null==root)
            return;
        
        map.putIfAbsent(x,new TreeMap<>());
        map.get(x).putIfAbsent(y,new TreeSet<>());
        map.get(x).get(y).add(root.data);
        
        helper(root.left,map,x-1,y+1);
        helper(root.right,map,x+1,y+1);
        
    }

}
