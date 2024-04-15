//package com.example.springboot;
//
//public class Node {
//    int value;
//    Node left, right;
//
//    public Node(int item) {
//        value = item;
//        left = right = null;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public Node getLeft() {
//        return left;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//
//    public void setLeft(Node left) {
//        this.left = left;
//    }
//
//    public void setRight(Node right) {
//        this.right = right;
//    }
//}

package com.example.springboot;

public class Node {
    int key, height;
    Node left, right;

    public Node(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public int getKey() {
        return key;
    }

    public int getHeight() {
        return height;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}

