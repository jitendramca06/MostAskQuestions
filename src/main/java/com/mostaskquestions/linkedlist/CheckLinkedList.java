package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class CheckLinkedList {
    private static boolean isSorted(Node root) {
        if (root == null || root.next == null) return true;
        return (root.data < root.next.data && isSorted(root.next));
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
        Node head = SortTheList.insertInSortedList(null, new Node(1));
        head = SortTheList.insertInSortedList(head, new Node(10));
        head = SortTheList.insertInSortedList(head, new Node(2));
        head = SortTheList.insertInSortedList(head, new Node(9));
        head = SortTheList.insertInSortedList(head, new Node(5));
        head = SortTheList.insertInSortedList(head, new Node(12));
        head = SortTheList.insertInSortedList(head, new Node(11));
        System.out.println(isSorted(head));
        Node node = new Node(3);
        node.next = head;
        head = node;
        print(head);
        System.out.println(isSorted(head));

    }
}
