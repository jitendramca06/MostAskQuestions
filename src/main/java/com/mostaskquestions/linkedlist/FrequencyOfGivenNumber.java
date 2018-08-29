package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class FrequencyOfGivenNumber {
    private static int frequency(Node root, int data) {
        Node temp = root;
        int count = 0;
        while (temp != null) {
            if (temp.data == data) count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(3);
        System.out.println(frequency(head1, 3));
    }
}
