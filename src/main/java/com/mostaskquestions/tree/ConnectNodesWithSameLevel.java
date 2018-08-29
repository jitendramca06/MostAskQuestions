package com.mostaskquestions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class ConnectNodesWithSameLevel {
    private static void connectAtLevel(TNode root) {
        if (root == null) return;
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TNode node = queue.poll();
            if (node != null) {
                node.nextRight = queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                if (queue.peek() != null) {
                    queue.add(null);
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        TNode root = new TNode(50);
        root.left = new TNode(30);
        root.right = new TNode(70);
        root.left.left = new TNode(20);
        root.left.right = new TNode(40);
        root.right.left = new TNode(60);
        root.right.right = new TNode(80);
        /**
         * http://javabypatel.blogspot.com/2015/08/connect-nodes-at-same-level-in-binary-tree-using-constant-extra-space.html
         * without any extra space
         */

        connectAtLevel(root);
        TNode temp = root;
        while (temp!= null) {
            TNode node = temp;
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.nextRight;
            }
            System.out.println();
            temp = temp.left;
        }
    }
}

class TNode {
    int data;
    TNode left;
    TNode right;
    TNode nextRight;

    TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}
