package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class FindKthNodeFromEnd {
    private static void findKThFromEnd(Node root, int k) {
        Node fast = root;
        int i = 0;
        while (i < k && fast != null) {
            fast = fast.next;
            i++;
        }
        Node slow = root;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println(slow.data);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        findKThFromEnd(root, 2);
    }
}
