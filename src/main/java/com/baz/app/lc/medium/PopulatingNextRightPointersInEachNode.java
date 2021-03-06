package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode implements Facebook {

    /**
     * Given a binary tree
     *
     * struct TreeLinkNode {
     *   TreeLinkNode *left;
     *   TreeLinkNode *right;
     *   TreeLinkNode *next;
     * }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     *
     * Note:
     *
     * You may only use constant extra space.
     * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
     * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     * Example:
     *
     * Given the following perfect binary tree,
     *
     *      1
     *    /  \
     *   2    3
     *  / \  / \
     * 4  5  6  7
     * After calling your function, the tree should look like:
     *
     *      1 -> NULL
     *    /  \
     *   2 -> 3 -> NULL
     *  / \  / \
     * 4->5->6->7 -> NULL
     */


    //Recursive Solution O(n) O(1)
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }

    //Iterative Solution O(n) O(1)
    public void connectIter(TreeLinkNode root){
        while (root != null){
            TreeLinkNode cur = root;
            while (cur!=null){
                if(cur.left != null) cur.left.next = cur.right;
                if(cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
    }

    //BFS O(N) O(N)

    public void test(){

    }

}
