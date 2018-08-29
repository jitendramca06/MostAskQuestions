package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class FindIntersectionPoint {
    private static void findIntersection(Node root1, Node root2) {
        Node temp1 = root1;
        int length1 = 0;
        while (temp1!= null) {
            length1++;
            temp1 = temp1.next;
        }

        Node temp2 = root2;
        int length2 = 0;
        while (temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }

        int diff = 0;
        if (length1 > length2) {
            diff = length1-length2;
            temp1 = root1;
            temp2 = root2;
            while (diff > 0) {
                temp1 = temp1.next;
                diff--;
            }
        }
        else {
            diff = length2 - length1;
            temp2 = root2;
            temp1 = root1;
            while (diff > 0) {
                temp2 = temp2.next;
                diff--;
            }
        }
        while (temp1.next != temp2.next) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1.next == temp2.next) {
            System.out.println("Intersection point is " + temp1.next.data);
        }
    }

    public static void main(String[] args) {
        // creating first linked list
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        // creating second linked list
        Node head2 = new Node(10);
        //head2.next = new Node(15);
        //head2.next.next = new Node(30);
        head2.next = head1.next.next.next;
        findIntersection(head1, head2);
    }
}
