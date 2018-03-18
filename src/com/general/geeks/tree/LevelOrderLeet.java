package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderLeet {
	
public List<List<Integer>> levelOrder(TreeNode root) {
        
	
	List<List<Integer>> lists = new ArrayList();
	level(root,lists);
	
	return lists;
    }


private static void level(TreeNode node,List<List<Integer>> lists) {
	int height = height(node);
	//change below for the reverse level order traversal
	for(int i=height;i>=1;i--) {
		List<Integer> list = new ArrayList();
		levelOrder(node, i,list);
		lists.add(list);
		//System.out.println();
	}
}

private static void levelOrder(TreeNode node , int level,List<Integer> list) {
	
	if(null==node) {
		return;
	}
	
	if(level==1) {
		list.add(node.data);
		//System.out.print(node.data+" ");
	}
	
	levelOrder(node.left,level-1,list);
	levelOrder(node.right,level-1,list);
	
}
private static int height(TreeNode tree) {
	if(null==tree) {
		return 0;
	}
	
	return 1+Math.max(height(tree.left), height(tree.right));
}
}
