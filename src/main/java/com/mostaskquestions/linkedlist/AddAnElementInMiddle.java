package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class AddAnElementInMiddle {
    private static void insertAtMid(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        } else {
            int len = 0;
            Node temp = root;
            while (temp != null) {
                temp = temp.next;
                len++;
            }

            int mid  = (len%2 == 0) ? len/2 : (len +1)/2;
            temp = root;
            while (mid-- > 1) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }
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
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        print(head1);
        insertAtMid(head1, 5);
        print(head1);
    }
}
