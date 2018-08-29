package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class FindMiddleElement {
    private static void findMid(Node root) {
        Node slowP = root;
        Node fastP = root;

        while (fastP.next != null && fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        System.out.println(slowP.data);
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

        findMid(root);
    }
}
