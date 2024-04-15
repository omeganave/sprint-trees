package com.example.springboot;

//import com.example.springboot.BinarySearchTree;
import com.example.springboot.BinaryTree;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BinaryTreeController {

    @Autowired
    private BinaryTreeRepository repository;

    @Autowired
    private AVLTreeService avlTreeService;

    @GetMapping("/")
    public String home() {
        return "redirect:/enter-numbers";
    }

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enterNumbers";
    }

//    @PostMapping("/process-numbers")
//    @ResponseBody
//    public BinaryTree processNumbers(@RequestParam("numbers") String numbers) throws JsonProcessingException {
//        String[] numberStrings = numbers.split(",");
//        BinarySearchTree bst = new BinarySearchTree();
//        for (String numberString : numberStrings) {
//            int number = Integer.parseInt(numberString.trim());
//            bst.insert(number);
//        }
//
//        String treeJson = bst.serializeToJson();
//
//        BinaryTree binaryTree = new BinaryTree(numbers, treeJson);
//        repository.save(binaryTree);
//
//        return binaryTree;
//    }

    // Duplicates are ignored when creating a tree.
    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) throws JsonProcessingException {
        String[] numberStrings = numbers.split(",");
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            avlTreeService.insert(number);
        }

        String treeJson = avlTreeService.serializeTree();

        BinaryTree binaryTree = new BinaryTree(numbers, treeJson);
        repository.save(binaryTree);

        model.addAttribute("numbers", numbers);
        model.addAttribute("treeJson", treeJson);

        avlTreeService.resetTree();

        return "processNumbers";
    }

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        List<BinaryTree> trees = repository.findAll();
        model.addAttribute("trees", trees);
        return "previousTrees";
    }

    @GetMapping("/test")
    public String test() {
        return "enterNumbers";
    }
}
