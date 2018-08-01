package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class DiameterOfBinaryTree {
    Integer max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        recusion(root);
        return max;
    }

    public int recusion(TreeNode node){
        if(node == null) return 0;
        int l = recusion(node.left);
        int r = recusion(node.right);
        max = Math.max(max, l+r);
        return Math.max(l , r) + 1;
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l1l2 = new TreeNode(4);
        TreeNode l1r2 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;

        Utils.inOrderPrintTree(root);
        System.out.println("");
        System.out.println(diameterOfBinaryTree(root));
    }

}