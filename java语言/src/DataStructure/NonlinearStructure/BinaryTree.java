package DataStructure.NonlinearStructure;

import DataStructure.LinearStructure.SequenceList.SqQueue;
import DataStructure.LinearStructure.SequenceList.sqStack;

class TreeNode{
    TreeNode leftChild;
    TreeNode rightChild;
    char value;
    public TreeNode(char value) {
        this.value = value;
        this.leftChild=null;
        this.rightChild=null;
    }
}

public class BinaryTree {
    private TreeNode root;
    private static int index = 0;;
    public BinaryTree() {
        root=null;
    }
    //添加节点
    private TreeNode addNode(String input){
        if (index >= input.length() || input.charAt(index) == '#') {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(input.charAt(index));
        index++;
        node.leftChild = addNode(input);
        node.rightChild = addNode(input);
        return node;
    }
    public void buildTree(String input){
        this.root = addNode(input);
    }
    //递归的前序遍历
    private void DlrTraverse(TreeNode Root){
        if (Root==null) return;
        else{
            System.out.print(Root.value+" ");
            DlrTraverse(Root.leftChild);
            DlrTraverse(Root.rightChild);
        }
    }
    public void DlrTraverse(){
        DlrTraverse(this.root);
    }
    //递归的中序遍历
    private void LdrTraverse(TreeNode Root){
        if (Root==null) return;
        else{
            LdrTraverse(Root.leftChild);
            System.out.print(Root.value+" ");
            LdrTraverse(Root.rightChild);
        }
    }
    public void LdrTraverse(){
        LdrTraverse(this.root);
    }
    //递归的后序遍历
    private void LrdTraverse(TreeNode Root){
        if (Root==null) return;
        else{
            LrdTraverse(Root.leftChild);
            LrdTraverse(Root.rightChild);
            System.out.print(Root.value+" ");
        }
    }
    public void LrdTraverse(){
        LrdTraverse(this.root);
    }
    //非递归的先序遍历
    private void  DlrTraverseByStack(TreeNode Root){
        if (Root==null) return;
        else{
            sqStack<TreeNode> Stack = new sqStack<TreeNode>(100);
            Stack.push(Root);
            while (!Stack.isEmpty()){
                TreeNode popNode = Stack.pop();
                System.out.print(popNode.value+" ");
                if (popNode.leftChild!=null)
                    DlrTraverseByStack(popNode.leftChild);
                if (popNode.rightChild!=null)
                    DlrTraverseByStack(popNode.rightChild);
            }
        }
    }
    public void DlrTraverseByStack(){
        DlrTraverseByStack(this.root);
    }
    //非递归的中序遍历
    private void  LdrTraverseByStack(TreeNode Root){
        if (Root==null) return;
        else{
            sqStack<TreeNode> Stack = new sqStack<>(100);
            TreeNode p=Root;
            while (p!=null|| !Stack.isEmpty()){
                if (p!=null){
                    Stack.push(p);
                    p=p.leftChild;
                }else{
                    TreeNode popNode = Stack.pop();
                    System.out.print(popNode.value+" ");
                    p=popNode.rightChild;
                }
            }
        }
    }
    public void LdrTraverseByStack(){
        LdrTraverseByStack(this.root);
    }
    //非递归的后序遍历
    private void  LrdTraverseByStack(TreeNode Root){
        if (Root==null) return;
        else{
            sqStack<TreeNode> Stack = new sqStack<>(100);
            sqStack<TreeNode> Stack1 = new sqStack<>(100);
            Stack.push(Root);
            while (!Stack.isEmpty()){
                TreeNode popNode = Stack.pop();
                Stack1.push(popNode);
                if (popNode.leftChild!=null)
                    Stack.push(popNode.leftChild);
                if (popNode.rightChild!=null)
                    Stack.push(popNode.rightChild);
            }
            while (!Stack1.isEmpty()){
                System.out.print(Stack1.pop().value+" ");
            }
        }
    }
    public void LrdTraverseByStack(){
        LrdTraverseByStack(this.root);
    }
    //二叉树的层次遍历
    private void levelTraverse(TreeNode Root){
        if (Root==null) return;
        else {
            SqQueue<TreeNode> SqQueue = new SqQueue<>(100);
            SqQueue.enqueue(Root);
            while (SqQueue.getSize()!=0){
                TreeNode deNode = SqQueue.dequeue();
                if (deNode.leftChild!=null)
                    SqQueue.enqueue(deNode.leftChild);
                if (deNode.rightChild!=null)
                    SqQueue.enqueue(deNode.rightChild);
            }
        }
    }
    public void levelTraverse(){
        levelTraverse(this.root);
    }
    //复制二叉树
    private TreeNode copyTree(TreeNode Root){
        if (Root==null){
            return null;
        }else{
            TreeNode newRoot=new TreeNode(Root.value);
            newRoot.leftChild=copyTree(Root.leftChild);
            newRoot.rightChild=copyTree(Root.rightChild);
            return newRoot;
        }
    }
    public void copyTree(BinaryTree tree){
        tree.root = copyTree(this.root);
    }
    //计算二叉树的深度
    private int Depth(TreeNode Root){
        if (Root==null) return 0;
        else{
           int m,n;
           m=Depth(Root.leftChild);
           n=Depth(Root.rightChild);
           return n>m?n+1:m+1;
        }
    }
    public int Depth(){
        return Depth(this.root);
    }
    //计算二叉树的结点数
    private int nodeCount(TreeNode Root){
        if (Root==null) return 0;
        else
            return nodeCount(Root.leftChild)+nodeCount(Root.rightChild)+1;
    }
    public int nodeCount(){
        return nodeCount(this.root);
    }
    //计算二叉树的叶子结点数
    private int LeadCount(TreeNode Root){
        if (Root==null) return 0;
        if (Root.leftChild==null&&Root.rightChild==null) return 1;
        else
            return LeadCount(Root.leftChild)+LeadCount(Root.rightChild);
    }
    public int LeadCount(){
        return LeadCount(this.root);
    }
}
