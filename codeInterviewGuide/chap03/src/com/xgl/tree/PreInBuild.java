package com.xgl.tree;

import java.util.HashMap;

public class PreInBuild {

    HashMap<Integer, Integer> inIndex = new HashMap<>();

    public Node buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public Node buildTree(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;
        int value = preorder[preStart];
        int index = inIndex.get(value);
        int leftSize = index - inStart;
        Node head = new Node(value);
        head.setLeft(buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1));
        head.setRight(buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd));
        return head;
    }
}
