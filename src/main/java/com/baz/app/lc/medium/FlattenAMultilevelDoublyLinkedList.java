package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class FlattenAMultilevelDoublyLinkedList implements Facebook {

    /**
     * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
     * which may or may not point to a separate doubly linked list.
     * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
     * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
     *
     * Example:
     * Input:
     *  1---2---3---4---5---6--NULL
     *          |
     *          7---8---9---10--NULL
     *              |
     *              11--12--NULL
     *
     * Output:
     * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
     *
     */

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    /**
     * Go through the linked list;
     * If
     * Node cur.child == null, skip, don't go into recursion.
     * Node cur.child != null, recurse and get child's tail node.
     *      Node tmp = cur.next,
     *      (1)connect cur <-> child,
     *      (2)connect child's tail <->tmp.
     * The helper function returns the tail node of current level.
     */
    public Node flatten(Node head) {
        helper(head);
        return head;
    }

    private Node helper(Node head) {
        Node cur = head, pre = head;
        while(cur != null) {
            if(cur.child == null) {
                pre = cur;
                cur = cur.next;
            } else {
                Node tmp = cur.next;
                Node child = helper(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                child.next = tmp;
                if(tmp != null) tmp.prev = child;
                pre = child;
                cur = tmp;
            }
        }
        return pre;
    }

    /**
     * Basic idea is straight forward:
     *
     * Start form the head , move one step each time to the next node
     * When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with p.next,
     *      by doing this we merged the child chain back to the main thread
     * Return to p and proceed until find next node with child.
     * Repeat until reach null
     */
    public Node flattenIter(Node head) {
        if( head == null) return head;
        // Pointer
        Node p = head;
        while( p!= null) {
            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while( temp.next != null )
                temp = temp.next;
            // Connect tail with p.next, if it is not null
            temp.next = p.next;
            if( p.next != null )  p.next.prev = temp;
            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }

}
