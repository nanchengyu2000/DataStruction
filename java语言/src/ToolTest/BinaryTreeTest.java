package ToolTest;

import DataStructure.NonlinearStructure.BinaryTree;

import java.util.Scanner;


public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        binaryTree.buildTree(scanner.next());
        System.out.println("递归类型：");
        binaryTree.DlrTraverse();
        System.out.println();
        binaryTree.LdrTraverse();
        System.out.println();
        binaryTree.LrdTraverse();
        System.out.println();
        System.out.println("非递归类型：");
        binaryTree.DlrTraverseByStack();
        System.out.println();
        binaryTree.LdrTraverseByStack();
        System.out.println();
        binaryTree.LrdTraverseByStack();
        System.out.println();
        System.out.println("二叉树深度：");
        System.out.println(binaryTree.Depth());
        System.out.println("二叉树叶子节点数：");
        System.out.println(binaryTree.LeadCount());
        System.out.println("二叉树的结点总数：");
        System.out.println(binaryTree.nodeCount());
        System.out.println("复制新的二叉树：");
        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree.copyTree(binaryTree1);
        binaryTree1.DlrTraverse();
    }
}
