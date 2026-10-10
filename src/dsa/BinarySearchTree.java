package dsa;

import java.util.ArrayList;
import java.util.List;

/** Binary search tree: insert, search, delete, traversal, height. */
public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        T value;
        Node left, right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node insert(Node node, T value) {
        if (node == null) return new Node(value);
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = insert(node.left, value);
        else if (cmp > 0) node.right = insert(node.right, value);
        return node; // duplicates are ignored
    }

    public boolean contains(T value) {
        Node cur = root;
        while (cur != null) {
            int cmp = value.compareTo(cur.value);
            if (cmp == 0) return true;
            cur = cmp < 0 ? cur.left : cur.right;
        }
        return false;
    }

    public void remove(T value) {
        root = remove(root, value);
    }

    private Node remove(Node node, T value) {
        if (node == null) return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = remove(node.left, value);
        } else if (cmp > 0) {
            node.right = remove(node.right, value);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = node.right;               // two children: use the in-order successor
            while (min.left != null) min = min.left;
            node.value = min.value;
            node.right = remove(node.right, min.value);
        }
        return node;
    }

    /** Values in sorted order. */
    public List<T> inOrder() {
        List<T> out = new ArrayList<>();
        inOrder(root, out);
        return out;
    }

    private void inOrder(Node node, List<T> out) {
        if (node == null) return;
        inOrder(node.left, out);
        out.add(node.value);
        inOrder(node.right, out);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }
}
