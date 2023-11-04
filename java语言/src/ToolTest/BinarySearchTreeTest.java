package ToolTest;

import DataStructure.NonlinearStructure.BinarySearchTree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.buildTree(5);
        tree.buildTree(2);
        tree.buildTree(3);
        tree.buildTree(3);
        tree.buildTree(7);
        tree.buildTree(6);
        tree.DlrTraverse();
        System.out.println();
        tree.LdrTraverse();
        System.out.println();
        System.out.println(tree.Search(8));
    }
}
