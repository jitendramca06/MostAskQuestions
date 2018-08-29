package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class SortTheList {
    public static Node insertInSortedList(Node root, Node node) {
        if (root == null) return node;
        if (root.next == null) {
            if (node.data <= root.data) {
                node.next = root;
                root =node;
            } else {
                root.next = node;
            }
            return root;
        }

        Node prev = root;
        Node temp = root.next;
        while (prev != null && temp != null) {
            if (prev.data<= node.data && node.data < temp.data) {
                prev.next = node;
                node.next = temp;
                return root;
            }
            prev = temp;
            temp = temp.next;
        }
        prev.next = node;
        return root;
    }
}
