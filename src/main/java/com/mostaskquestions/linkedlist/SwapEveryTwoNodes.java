package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class SwapEveryTwoNodes {
    private static void swapEveryTwo(Node root) {
        Node temp = root;

        /* Traverse only till there are atleast 2 nodes left
        Time complexity: O(n)
         *  */
        while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
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
        swapEveryTwo(head1);
        print(head1);
    }
}
