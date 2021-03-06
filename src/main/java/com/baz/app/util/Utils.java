package com.baz.app.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
* <h1>java code utils</h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-18
*/
public class Utils{

    /**
     * print int[][] Matrix
     * */
    public static void printMatrix(int [][] a , int rows, int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + " ");
            }
                System.out.println();
        }
    }
    public static void printMatrix(Integer [][] a , Integer rows, Integer cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printMatrix(int [][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printMatrix(Integer [][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * preOrder traverse BinaryTree
     * */
    public static void preOrderPrintTree(TreeNode root){
        if(root!=null){
            System.out.print(root.val + " | ");
            preOrderPrintTree(root.left);
            preOrderPrintTree(root.right);
        }
    }
    /**
     * postOrder traverse BinaryTree
     * */
    public static void postOrderPrintTree(TreeNode root){
        if(root!=null){
            postOrderPrintTree(root.left);
            postOrderPrintTree(root.right);
            System.out.print(root.val + " | ");
        }
    }
    /**
     * inOrder traverse BinaryTree
     * */
    public static void inOrderPrintTree(TreeNode root){
        if(root!=null){
            inOrderPrintTree(root.left);
            System.out.print(root.val + " | ");
            inOrderPrintTree(root.right);
        }
    }
    /**
     * print Object[] array
     * */
    public static void printArray(Object[] arr){
        System.out.print("| ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i].toString() + " | ");
        }
        System.out.println();
    }
    /**
     * print int[] array
     * */
    public static void printArray(int[] arr){
        System.out.print("| ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
    /**
     * print double[] array
     * */
    public static void printArray(double[] arr){
        System.out.print("| ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
    /**
     * print SingleLinkedList ListNode
     * */
    public static void printLinkedList(ListNode node){
        System.out.print("| ");
        while(node != null){
            System.out.print(node.val + " | ");
            node = node.next;
        }
    }

    /**
     * print SingleLinkedList ListNode
     * */
    public static void printCyclicLinkedList(ListNode node){
        ListNode head = node;
        System.out.print("head:");
        while(node.next != null && node.next != head){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print(node.val);
    }

    /**
     * bfs traverse undirected graph
     * */
    public static void bfsTraverseUndirectedGraph(UndirectedGraphNode start){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, Integer> map = new HashMap<>();

        map.put(start, map.getOrDefault(start,0) + 1);
        queue.offer(start);

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                UndirectedGraphNode cur = queue.poll();
                System.out.printf(cur.label + " -> ");
                if(cur.neighbors != null){
                    for (UndirectedGraphNode n : cur.neighbors){
                        if(map.getOrDefault(n,0) < 1){
                            queue.offer(n);
                            map.put(n, map.getOrDefault(n,0) + 1);
                        }
                    }
                }
            }
        }
    }
}