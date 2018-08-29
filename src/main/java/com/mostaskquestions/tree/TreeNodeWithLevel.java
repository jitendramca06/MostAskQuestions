package com.mostaskquestions.tree;

/**
 * @author Jitendra Kumar : 29/8/18
 */
public class TreeNodeWithLevel {
    int data;
    TreeNodeWithLevel left;
    TreeNodeWithLevel right;
    int level;

    TreeNodeWithLevel(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.level = 0;
    }
}
