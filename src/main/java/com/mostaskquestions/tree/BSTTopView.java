package com.mostaskquestions.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Jitendra Kumar : 29/8/18
 */
public class BSTTopView {
    private static void topViewOfTreeRec(TreeMap<Integer, String> treeMap, TreeNodeWithLevel root, int level) {
        if (root == null) return;
        if (!treeMap.containsKey(level)) treeMap.put(level, root.data + "");
        topViewOfTreeRec(treeMap, root.left, level - 1);
        topViewOfTreeRec(treeMap, root.right, level + 1);

    }

    private static void topViewOfTreeIte(TreeMap<Integer, String> treeMap, TreeNodeWithLevel root) {
        if (root == null) return;
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNodeWithLevel node = queue.poll();
            if (!treeMap.containsKey(node.level)) treeMap.put(node.level, node.data + "");

            if (node.left != null) {
                node.left.level = node.level -1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.level = node.level + 1;
                queue.add(node.right);
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
        TreeNodeWithLevel root = new TreeNodeWithLevel(50);
        root.left = new TreeNodeWithLevel(30);
        root.right = new TreeNodeWithLevel(70);
        root.left.left = new TreeNodeWithLevel(20);
        root.left.right = new TreeNodeWithLevel(40);
        root.right.left = new TreeNodeWithLevel(60);
        root.right.right = new TreeNodeWithLevel(80);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        topViewOfTreeIte(treeMap, root);
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }

        System.out.println();
        treeMap = new TreeMap<>();
        topViewOfTreeRec(treeMap, root, 0);
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }
    }
}
