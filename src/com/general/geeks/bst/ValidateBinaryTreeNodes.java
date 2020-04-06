package com.general.geeks.bst;

/**
 *
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 *
 */
public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] indegree = new int[n];
        for(int i=0;i<n;i++) {
            if(leftChild[i]!=-1 && indegree[leftChild[i]]++==1)
                return false;
            if(rightChild[i]!=-1 && indegree[rightChild[i]]++==1)
                return false;

        }

        int root = -1;

        for(int i=0;i<n;i++) {
            if(indegree[i]==0)
                if(root!=-1)
                    return false;
                root = i;

        }

        return root!=-1 && dfs(root,new boolean[n],leftChild,rightChild);

    }

    private boolean dfs(int root,boolean[] visited,int[] leftChild,int[] rightChild) {

        if(root==-1)
            return true;
        if(visited[root])
            return false;

        visited[root] = true;

        return dfs(leftChild[root],visited,leftChild,rightChild) && dfs(rightChild[root],visited,leftChild,rightChild);


    }
}
