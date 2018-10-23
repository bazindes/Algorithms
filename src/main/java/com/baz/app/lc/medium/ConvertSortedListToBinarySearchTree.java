package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.ListNode;
import com.baz.app.util.TreeNode;

public class ConvertSortedListToBinarySearchTree implements Facebook {

    /**
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
     * subtrees of every node never differ by more than 1.
     *
     * Example:
     * Given the sorted linked list: [-10,-3,0,5,9],
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */

    //O(nlogn) O(1)
    ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = 0;
        ListNode runner = head;
        node = head;
        while (runner != null){
            size ++;
            runner = runner.next;
        }
        return helper(0 , size);
    }

    private TreeNode helper(int start, int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode temp = new TreeNode(node.val);
        temp.left = left;
        node = node.next;
        temp.right = helper(mid + 1, end);
        return temp;
    }

    public void test(){

    }

}
