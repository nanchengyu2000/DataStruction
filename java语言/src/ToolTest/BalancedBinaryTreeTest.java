package ToolTest;

import DataStructure.NonlinearStructure.BalancedBinaryTree;

public class BalancedBinaryTreeTest {
    /*
* ƽ��������ķ���ʵ�ֳɹ�����һ�������ǽڵ�ĸ߶������⣬Ҫȥ���������������
* 7--height:5 3--height:4 1--height:2 5--height:2 9--height:3 8--height:2 10--height:1
1--height:2 3--height:4 5--height:2 7--height:5 8--height:2 9--height:3 10--height:1
---------------------
8--height:3 7--height:2 9--height:2
7--height:2 8--height:3 9--height:2
*
* ����Ľ���������ڸ�����ת��û�и��¸߶�
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
        //����صݵ�ʱ��3�ĸ߶�����������ȷ ---����������¸߶ȷ�����ת���棬֮ǰ3�ĸ߶�Ϊ5��ԭ����3����ת����¸߶���+1
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
