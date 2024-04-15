package com.example.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class AVLTreeService {

    private AVLTree avlTree = new AVLTree();
    private Node root;

    public AVLTreeService() {
        this.root = null;
    }

    public void insert(int key) {
        avlTree.root = avlTree.insert(avlTree.root, key);
        System.out.println("After inserting " + key + ": " + serializeTree());
    }

//    private Node insertRec(Node node, int key) {
//        return node;
//    }

    public String serializeTree(){
        return serializeToJson(avlTree.root);
    }

    private String serializeToJson(Node node){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(node);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void resetTree() {
        avlTree.resetTree();
    }
}
