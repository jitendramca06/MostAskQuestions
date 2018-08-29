package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class MergeTwoSortedLists {
    private static Node merge(Node root1, Node root2){
        if (root1 == null && root2 == null) return root1;
        if (root1 == null && root2 != null) return root2;
        if (root1 != null && root2 == null) return root1;
        Node head = null;
        Node head1 = null;
        while (root1 != null && root2 != null) {
            if (root1.data <= root2.data) {
                if (head == null) {
                    head = root1;
                    head1 = head;
                }
                else {
                    head.next = root1;
                    head = head.next;
                }
                root1 = root1.next;
            } else {
                if (head == null) {
                    head = root2;
                    head1 = head;
                }
                else {
                    head.next = root2;
                    head = head.next;
                }
                root2 = root2.next;
            }
        }

        while (root1 != null) {
            head.next = root1;
            head = head.next;
            root1 = root1.next;
        }

        while (root2 != null) {
            head.next = root2;
            head = head.next;
            root2 = root2.next;
        }
        return head1;
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

        Node head2 = new Node(2);
        head2.next = new Node(10);
        head2.next.next = new Node(12);
        head2.next.next.next = new Node(18);
        head2.next.next.next.next = new Node(40);
        Node head = merge(head1, head2);
        print(head);
    }
}
