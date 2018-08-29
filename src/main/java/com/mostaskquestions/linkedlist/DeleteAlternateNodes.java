package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class DeleteAlternateNodes {
    private static void delete(Node root) {
        Node temp = root;
        while (temp.next != null && temp.next.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
        if (temp.next != null && temp.next.next == null) temp.next = null;
    }

    private static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // creating first linked list
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);
        head1.next.next.next.next.next = new Node(35);
        print(head1);
        delete(head1);
        print(head1);
    }
}
