package com.mostaskquestions.linkedlist;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class FindSumOfList {
    private static Node sumOfList(Node root1, Node root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();

        Node temp1 = root1;
        while (temp1 != null) {
            s1.push(temp1.data);
            temp1 = temp1.next;
        }

        Node temp2 = root2;
        while (temp2 != null) {
            s2.push(temp2.data);
            temp2 = temp2.next;
        }

        int sum = 0, carry = 0, value1, value2;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            value1 = s1.pop();
            value2 = s2.pop();

            sum = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            s3.push(sum);
        }

        while (!s1.isEmpty()) {
            value1 = s1.pop();

            sum = (value1 + carry) % 10;
            carry = (value1 + carry) / 10;
            s3.push(sum);
        }

        while (!s2.isEmpty()) {
            value2 = s2.pop();

            sum = (value2 + carry) % 10;
            carry = (value2 + carry) / 10;
            s3.push(sum);
        }

        if (carry > 0) s3.push(carry);
        return createList(s3);
    }

    private static Node createList(Stack<Integer> s3) {
        Node root = null;
        Node tail = null;
        while (!s3.isEmpty()) {
            Node node = new Node(s3.pop());
            if (tail == null) {
                tail = node;
                root = tail;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return root;
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
        // creating first linked list
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        //head1.next.next.next.next = new Node(30);

        // creating first linked list
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
        //head2.next.next.next = new Node(15);
        //head2.next.next.next.next = new Node(30);
        Node fList = sumOfList(head1, head2);
        print(fList);
    }

    private Node addListsRecursive(Node node1, Node node2, int carry) {

        if (node1 == null && node2 == null) {
            if (carry > 0) {
                return new Node(carry);
            }
            return null;
        }


        int value1 = (node1 != null) ? node1.data : 0;
        int value2 = (node2 != null) ? node2.data : 0;


        int sum = (value1 + value2 + carry) % 10;
        carry = (value1 + value2 + carry) / 10;


        Node currentHead = new Node(sum);


        Node node1Next = (node1 != null) ? node1.next : null;
        Node node2Next = (node2 != null) ? node2.next : null;


        currentHead.next = addListsRecursive(node1Next, node2Next, carry);

        return currentHead;
    }

    private Node addListsIterative(Node node1, Node node2) {

        Node result = null;


        Node tempTail = result;

        int sum = 0, carry = 0;
        while ((node1 != null) || (node2 != null)) {

            int value1 = (node1 != null) ? node1.data : 0;
            int value2 = (node2 != null) ? node2.data : 0;


            sum = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;

            Node newNode = new Node(sum);
            if (tempTail == null) {
                tempTail = newNode;
            } else {
                tempTail.next = newNode;
                tempTail = newNode;
            }


            if (result == null) {
                result = tempTail;
            }


            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
        }

        if (carry > 0) {
            Node carryNode = new Node(carry);
            if (tempTail == null) {
                tempTail = carryNode;
            } else {
                tempTail.next = carryNode;
                tempTail = carryNode;
            }
        }

        return result;
    }
}
