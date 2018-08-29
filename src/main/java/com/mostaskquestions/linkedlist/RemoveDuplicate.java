package com.mostaskquestions.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class RemoveDuplicate {
    private static void removeDuplicate(Node root) {
        Node temp = root;
        while (temp != null) {
            Node prev = temp;
            Node temp1 = temp.next;
            while (temp1 != null) {
                if (temp1.data == temp.data) {
                    prev.next = temp1.next;
                    temp1 = temp1.next;
                    continue;
                } else {
                    prev = temp1;
                    temp1 = temp1.next;
                }
            }
            temp = temp.next;
        }
    }

    private static void removeDuplicateFromSorted(Node root) {
        if (root == null && root.next == null) return;
        if (root.next.next == null) {
            if (root.data == root.next.data) {
                root.next = null;
                return;
            }
        }

        Node prev = root;
        Node current = root.next;
        while (current!= null) {
            if (prev.data == current.data) {
                prev.next = current.next;
                current = current.next;
                continue;
            } else {
                prev = current;
                current = current.next;
            }
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
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        Node node5 = new Node(1);
        Node node6 = new Node(3);
        root = SortTheList.insertInSortedList(null, root);
        root = SortTheList.insertInSortedList(root, node1);
        root = SortTheList.insertInSortedList(root, node2);
        root = SortTheList.insertInSortedList(root, node3);
        root = SortTheList.insertInSortedList(root, node4);
        root = SortTheList.insertInSortedList(root, node5);
        root = SortTheList.insertInSortedList(root, node6);
        print(root);
        removeDuplicateFromSorted(root);
        print(root);

        /*root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        print(root);
        removeDuplicate(root);
        print(root);*/
    }
}
