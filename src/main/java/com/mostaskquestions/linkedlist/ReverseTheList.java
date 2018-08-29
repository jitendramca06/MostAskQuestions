package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class ReverseTheList {
    static Node head;

    // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    private static Node reverseUtil(Node curr, Node prev) {

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;
            return null;
        }

        /* Save curr->next node for recursive call */
        Node next1 = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next1, curr);
        return head;
    }

    private static Node reverse(Node node) {
        /**
         * Time Complexity: O(n)
         * Space Complexity: O(1)
         */
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;

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
        head = root;
        print(root);
       /* Node temp = reverse(root);
        print(temp);*/

        Node temp = reverseUtil(root, null);
        print(temp);
    }
}
