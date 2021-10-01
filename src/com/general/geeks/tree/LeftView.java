package com.general.geeks.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeftView {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(6);
        node.right.right.left = new TreeNode(16);


        List<TreeNode> resp = new LinkedList<>();
        resp.add(node);
        leftView(node,resp,1);

        for(TreeNode n : resp)
            System.out.println(n.data+" ");
    }

    public static  void leftView(TreeNode node, List<TreeNode> resp,int currLevel) {
        if(null==node)
            return;
        if(currLevel>resp.size())
            resp.add(node);

        leftView(node.left,resp,currLevel+1);
        leftView(node.right,resp,currLevel+1);


    }
}
