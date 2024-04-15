package com.example.springboot;

import com.example.springboot.BinaryTree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinaryTreeRepository extends JpaRepository<BinaryTree, Long> {

}