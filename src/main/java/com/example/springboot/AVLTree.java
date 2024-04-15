package com.example.springboot;

public class AVLTree {
    Node root;

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    Node rightRotate(Node y) {
        System.out.println("Performing Right Rotation on Node Key: " + y.key);
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        System.out.println("Right Rotation Completed. New Root of Subtree: " + x.key);

        return x;
    }

    Node leftRotate(Node x) {
        System.out.println("Performing Left Rotation on Node Key: " + x.key);
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        System.out.println("Left Rotation Completed. New Root of Subtree: " + y.key);

        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;
        int balance = height(N.left) - height(N.right);
        System.out.println("Balance at Node Key: " + (N == null ? "null" : N.key) + " = " + balance);
        return balance;
    }

    Node insert(Node node, int key) {
        if (node == null) {
            System.out.println("Inserting new node with key " + key);
            return (new Node(key));
        }

        System.out.println("Insert: Current Key: " + node.key + ", Inserting Key: " + key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        System.out.println("Balance at Node Key " + node.key + " is " + balance);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        printTree(root, "", true);

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key + "(" + node.height + ") ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.key);
            printTree(node.left, prefix + (isLeft ? "|   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "|   " : "    "), false);
        }
    }

    public void resetTree() {
        root = null;
    }
}
