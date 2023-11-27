package DataStructure.NonlinearStructure;


import DataStructure.LinearStructure.SequenceList.SqQueue;

import java.util.LinkedList;

public class Tree<T> {
    Node<T> Root;

    public Tree() {
        Root = null;
    }

    public Node<T> getRoot() {
        return Root;
    }

    public class Node<T>{
        T value;
        LinkedList<Node<T>> ChildTree;
        public Node(T value) {
            this.value = value;
        }
    }
    //创建一个根
    private Node<T> createNode(T value,LinkedList<Node<T>> child){
        Node<T> node = new Node<>(value);
        node.ChildTree=child;
        return node;
    }
    //获取根的某一个子结点
    public Node<T> getNode(Node<T> node,int index){
        LinkedList<Node<T>> childTree = node.ChildTree;
        return childTree.get(index);
    }
    //构建一颗树
    public void buildTree(T rootValue){
        this.Root = createNode(rootValue, null);
    }
    //向一个结点添加子结点
    public void addChild(Node<T> node,LinkedList<T> child){
        if (node.ChildTree==null){
            LinkedList<Node<T>> childs = new LinkedList<>();
            for (T t : child) {
                Node<T> node1 = createNode(t,null);
                childs.add(node1);
            }
            node.ChildTree=childs;
        }else {
            for (T value : child) {
                Node<T> node1 = createNode(value, null);
                node.ChildTree.add(node1);
            }
        }
    }
    //进行树的先根遍历
    public void preorderTraverse(Node<T> node){
        if (node==null) return;
        System.out.print(node.value+" ");
        if (node.ChildTree!=null){
            for (Node<T> tNode : node.ChildTree) {
                preorderTraverse(tNode);
            }
        }
    }
    //进行树的后根遍历
    public void epilogueTraverse(Node<T> node){
        if (node==null) return;
        else {
            if (node.ChildTree!=null){
                for (Node<T> tNode : node.ChildTree) {
                    epilogueTraverse(tNode);
                }
            }
            System.out.print(node.value+" ");
        }
    }
    //对树进行层次遍历
    public void levelTraverse(){
        SqQueue<Node<T>> SqQueue = new SqQueue<Node<T>>(100);
        SqQueue.enqueue(this.Root);
        while (SqQueue.getSize()!=0){
            Node<T> deNode = SqQueue.dequeue();
            System.out.print(deNode.value+" ");
            if (deNode.ChildTree!=null){
                for (Node<T> tNode : deNode.ChildTree) {
                    SqQueue.enqueue(tNode);
                }
            }
        }
    }
}
