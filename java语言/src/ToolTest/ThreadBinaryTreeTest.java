package ToolTest;

import DataStructure.NonlinearStructure.ThreadBinaryTree;

import java.util.Scanner;

public class ThreadBinaryTreeTest {
    public static void main(String[] args) {
        ThreadBinaryTree tree = new ThreadBinaryTree();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        tree.buildTree(input);
        tree.buildThread(tree.getRoot());
        tree.inThreadList(tree.getRoot());
    }
}
