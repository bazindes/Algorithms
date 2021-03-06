package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.Interface.Google.Google;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.*;

public class BinaryTreePaths implements Facebook, Google {

    /**
     * Given a binary tree, return all root-to-leaf paths.
     * Note: A leaf is a node with no children.
     * Example:
     * Input:
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     * Output: ["1->2->5", "1->3"]
     * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     */

    //Recursion
    public List<String> binaryTreePathsRecursive(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root != null){
            StringBuilder sb = new StringBuilder();
            binaryTreePathsRecursiveHelper(root, list, sb);
        }
        return list;
    }

    private void binaryTreePathsRecursiveHelper(TreeNode node, List<String> list, StringBuilder sb){
        if(node == null) return;
        int len = sb.length();
        sb.append(node.val);
        if(node.left == null && node.right == null){
            list.add(sb.toString());
        }else {
            sb.append("->");
            binaryTreePathsRecursiveHelper(node.left, list, sb );
            binaryTreePathsRecursiveHelper(node.right, list, sb );
        }
        sb.setLength(len);
    }

    //dfs O(n) O(n)
    public List<String> binaryTreePaths(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        dfsHelper(root, list);
        return list;
    }

    private void dfsHelper(TreeNode node, List<String> list){
        Stack<TreeNode> nodesStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodesStack.push(node);
        pathStack.push(node.val + "");

        while (!nodesStack.isEmpty()){
            TreeNode n = nodesStack.pop();
            String curPath = pathStack.pop();
            if(n.left == null && n.right == null){
                list.add(curPath);
            }else {
                if(n.left != null){
                    nodesStack.push(n.left);
                    pathStack.push(curPath + "->" + n.left.val);
                }
                if (n.right != null) {
                    nodesStack.push(n.right);
                    pathStack.push(curPath + "->" + n.right.val);
                }
            }
        }

    }

    //BFS - Queue O(n) O(n)
    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> list=new ArrayList<String>();
        Queue<TreeNode> qNode=new LinkedList<TreeNode>();
        Queue<String> qStr=new LinkedList<String>();

        if (root==null) return list;
        qNode.add(root);
        qStr.add("");
        while(!qNode.isEmpty()) {
            TreeNode curNode=qNode.remove();
            String curStr=qStr.remove();

            if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
            if (curNode.left!=null) {
                qNode.add(curNode.left);
                qStr.add(curStr+curNode.val+"->");
            }
            if (curNode.right!=null) {
                qNode.add(curNode.right);
                qStr.add(curStr+curNode.val+"->");
            }
        }
        return list;
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.right = l1r2;
        Utils.inOrderPrintTree(root);
        System.out.println();
        binaryTreePathsRecursive(root).forEach(System.out::println);
    }

}
