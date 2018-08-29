package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class FindLoopAndRemoveLoop {
    private static void findLoop(Node root) {
        Node slowP = root;
        Node fastP = root;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (fastP == slowP) {
                System.out.print("Loop found at ");
                //removeLoop(root, slowP);
                removeLoop1(root, fastP);
                break;
            }
        }
        System.out.println();
    }

    private static void removeLoop(Node root, Node findLoop) {
        Node head = root;
        Node current = null;

        while (head != null) {
            current = findLoop;
            while (current.next != findLoop && current.next != head)
                current = current.next;
            if (current.next == head) {
                System.out.print(head.data);
                break;
            }
            else head = head.next;
        }
        current.next = null;
    }

    private static void removeLoop1(Node root, Node fastP) {
        Node head = root;

        while (fastP.next != head.next) {
            fastP = fastP.next;
            head = head.next;
        }
        System.out.print(fastP.next.data);
        fastP.next = null;
    }

    private static void print(Node root) {
        Node temp = root;
        while (temp!= null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        findLoop(head);
        System.out.println("Linked List after removing loop : ");
        print(head);
    }
}
