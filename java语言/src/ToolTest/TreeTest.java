package ToolTest;

import DataStructure.NonlinearStructure.Tree;

import java.util.LinkedList;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.buildTree(10);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        tree.addChild(tree.getRoot(),integers);
        Tree<Integer>.Node<Integer> node = tree.getNode(tree.getRoot(), 1);
        LinkedList<Integer> integers1 = new LinkedList<>();
        integers1.add(11);
        integers1.add(21);
        tree.addChild(node,integers1);
        tree.preorderTraverse(tree.getRoot());
        System.out.println();
        tree.epilogueTraverse(tree.getRoot());
        System.out.println();
        tree.levelTraverse();
    }
}
