package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class ReverseKNodes {
    private static Node reverseKNodes(Node start, int k) {

        if (start == null || k < 2) {
            return null;
        }

        Node prev = null;
        Node curr = start;
        Node next = null;

        int i = 1;
        while (curr.next != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        next = curr.next;
        curr.next = prev;
        return curr;
    }

    public static Node reverseKAlternateNodes(Node head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }


        Node temp = head;
        int i = 0;
        while (i < k && temp != null) {
            temp = temp.next;
            i++;
        }


        head = reverseKNodes(head, k);
        Node next = head;
        while (next.next != null) {
            next = next.next;
        }
        next.next = temp;


        i = 0;
        Node prev = null;
        while (i < k && temp != null) {
            prev = temp;
            temp = temp.next;
            i++;
        }

        if (temp != null) {
            prev.next = reverseKAlternateNodes(temp, k);
        }

        return head;
    }

    /* Reverses alternate k nodes and
     returns the pointer to the new head node */
    private static Node kAltReverse(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;

        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* 2) Now head points to the kth node.  So change next
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }

        /* 3) We do not want to reverse next k nodes. So move the current
         pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }

        /* 5) prev is new head of the input list */
        return prev;
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
        head1.next.next.next.next.next = new Node(35);
        print(head1);
        Node head = kAltReverse(head1, 2);
        print(head);
    }
}
