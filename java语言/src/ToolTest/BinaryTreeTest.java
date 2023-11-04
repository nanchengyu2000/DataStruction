package ToolTest;

import DataStructure.NonlinearStructure.BinaryTree;

import java.util.Scanner;


public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        binaryTree.buildTree(scanner.next());
        System.out.println("�ݹ����ͣ�");
        binaryTree.DlrTraverse();
        System.out.println();
        binaryTree.LdrTraverse();
        System.out.println();
        binaryTree.LrdTraverse();
        System.out.println();
        System.out.println("�ǵݹ����ͣ�");
        binaryTree.DlrTraverseByStack();
        System.out.println();
        binaryTree.LdrTraverseByStack();
        System.out.println();
        binaryTree.LrdTraverseByStack();
        System.out.println();
        System.out.println("��������ȣ�");
        System.out.println(binaryTree.Depth());
        System.out.println("������Ҷ�ӽڵ�����");
        System.out.println(binaryTree.LeadCount());
        System.out.println("�������Ľ��������");
        System.out.println(binaryTree.nodeCount());
        System.out.println("�����µĶ�������");
        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree.copyTree(binaryTree1);
        binaryTree1.DlrTraverse();
    }
}
