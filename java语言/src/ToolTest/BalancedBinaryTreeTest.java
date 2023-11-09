package ToolTest;

import DataStructure.NonlinearStructure.BalancedBinaryTree;

public class BalancedBinaryTreeTest {
    /*
* 平衡二叉树的方法实现成功但是一点错误就是节点的高度有问题，要去看看是哪里的问题
* 7--height:5 3--height:4 1--height:2 5--height:2 9--height:3 8--height:2 10--height:1
1--height:2 3--height:4 5--height:2 7--height:5 8--height:2 9--height:3 10--height:1
---------------------
8--height:3 7--height:2 9--height:2
7--height:2 8--height:3 9--height:2
*
* 这里的解决方案是在各种旋转中没有更新高度
* */
    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.buildTree(5);
        tree.buildTree(7);
        tree.buildTree(2);
        tree.buildTree(1);
        tree.buildTree(3);
        tree.buildTree(4);
        tree.buildTree(8);
        tree.buildTree(9);
        tree.buildTree(10);
        tree.delete(7);
        //这里回递的时候3的高度有误，其他正确 ---解决：将更新高度放在旋转后面，之前3的高度为5，原因是3在旋转后更新高度是+1
        tree.DlrTraverse();
        System.out.println();
        tree.LdrTraverse();
        System.out.println();
        System.out.println("---------------------");
        BalancedBinaryTree tree1 = new BalancedBinaryTree();
//        tree1.buildTree(7);
//        tree1.buildTree(9);
//        tree1.buildTree(8);
        tree1.DlrTraverse();
        System.out.println();
        tree1.LdrTraverse();
        System.out.println();
    }
}
