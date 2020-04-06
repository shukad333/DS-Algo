package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 *
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> resp = new ArrayList<>();
        if(null==root)
            return resp;
        helper(resp,root,0);
        return resp;

    }

    private void helper(List<List<Integer>> resp,TreeNode root,int height) {


        if(resp.size()==height) {
            resp.set(0,new ArrayList<>());
        }

        System.out.println(resp);
        resp.get(0).add(root.data);

        if(root.left!=null)
            helper(resp,root.left,height+1);
        if(root.right!=null)
            helper(resp,root.right,height+1);

    }
}
