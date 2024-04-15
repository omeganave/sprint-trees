//package com.example.springboot;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class BinarySearchTree {
//    Node root;
//
//    BinarySearchTree() {
//        root = null;
//    }
//
//    void insert(int value) {
//        root = insertRec(root, value);
//    }
//
//    Node insertRec(Node root, int value) {
//        if (root == null) {
//            root = new Node(value);
//            return root;
//        }
//
//        if (value < root.value) {
//            root.left = insertRec(root.left, value);
//        } else if (value > root.value) {
//            root.right = insertRec(root.right, value);
//        }
//
//        return root;
//    }
//
//    String serializeToJson() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(this.root);
//    }
//}
