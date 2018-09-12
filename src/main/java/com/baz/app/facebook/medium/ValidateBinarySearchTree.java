package com.baz.app.facebook.medium;

import com.baz.app.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
    /**
     * Recursion O(n) O(n)
     * */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i - 1) >= list.get(i))
                return false;
        }
        return true;
    }

    private void helper(TreeNode node, List<Integer> list){
        if(node == null) return;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }

    /**
     * Iterator O(n) O(n)
     * */
    public boolean isValidBSTIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }

        return true;
    }

    //O(n) O(1)
    public boolean isValidBSTConstSpace(TreeNode root){
        return constSpaceHelper(root, null, null);
    }

    private boolean constSpaceHelper(TreeNode node, Integer left, Integer right){
        if(node == null) return true;

        if(left != null && node.val <= left || right != null && node.val >= right)
            return false;

        return constSpaceHelper(node.left, left, node.val) && constSpaceHelper(node.right, node.val, right);
    }

    public void test(){
        TreeNode root = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTConstSpace(root));

        TreeNode _root = new TreeNode(5);
        TreeNode _l1 = new TreeNode(1);
        TreeNode _r1 = new TreeNode(4);
        TreeNode _r1l2 = new TreeNode(3);
        TreeNode _r1r2 = new TreeNode(6);
        _root.left = _l1;
        _root.right = _r1;
        _r1.left = _r1l2;
        _r1.right = _r1r2;
        System.out.println(isValidBST(_root));
        System.out.println(isValidBSTConstSpace(_root));
    }

}
