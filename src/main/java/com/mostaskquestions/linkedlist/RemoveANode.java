package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class RemoveANode {
    private static void remove(Node head, Node given) {
        Node temp = head;
        while (temp.next != null && temp.next != given)
            temp = temp.next;
        if (temp.next == null) {
            System.out.println("Given node is not found in list.");
            return;
        }
        if (temp.next == given) {
            System.out.println("Given node is found and removing from list");
            temp.next = given.next;
            return;
        }
    }

    private static void print(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
        System.out.println();
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
        System.out.println();
        print(root);
        remove(root, new Node(10));
        print(root);
    }
}
