package DataStructure.NonlinearStructure;

import java.util.LinkedList;
import java.util.Queue;

/*
* 视频中没有讲到堆，这里我将对堆进行一个理解
* 堆的定义：
* 1、必须是一个完全二叉树
* 2、堆序性： 可以将堆分为两类
*       大根堆：每个父节点要比左右子节点要大
*       小根堆：每个父节点要小于左右子节点
* 一个堆使用一个数组来进行描述
* 因为堆是一个完全二叉树，将树中的每个节点按照满二叉树进行，标注下标
* 这些下面对应数组的下面按层级依次将树的节点存放进数组中，这样就能将一个堆转换成为一个数组了
* 画图可知 当前节点下标为i，左节点的下标为2i+1,右节点的下标为2i+2，这个规律在算法中经常使用
* 但是数组转堆，需要经过堆的基本操作（上虑，下虑），因为数组转堆可能破坏堆的性质
* 上虑：
* 假设给你一颗树
*        1
*      /  \
*     7    6
*    / \  / \
*   4  5  1  2
* 其中破坏堆的性质的节点是根节点，1,按照大根堆；需要将1与左节点和右节点的最大值进行交换，后续操作一样，最后转化成合格的堆
*         7
 *      /  \
 *     5    6
 *    / \  / \
 *   4  1  1  2
 * 以上的操作就是下虑，复杂度为O(logN)
 * 下虑：
 *        7
 *      /  \
 *     5    6
 *    / \  / \
 *   4  1  1  8
 * 只有最后一个节点破坏了堆的性质，8，按照大根堆，需要将这个节点与父节点进行交换，在进行上一步操作，最后转换成一个合格的堆
 *        8
 *      /  \
 *     5    7
 *    / \  / \
 *   4  1  1  6
 * 以上的操作就是上虑，时间复杂度也是O(logN),这个操作主要用于新元素插入到堆中
 *
 * 建堆：
 * 给你一个乱序的数组，该如何建堆？
 * ①自顶向下【对应的操作为上虑】：
 *思路：将数组中的元素依次插入到堆内，插入一个元素后进行一次校验，看是否插入的元素导致堆的性质被破坏，
 * 如果破坏就将该节点进行上虑   复杂度为O(NlogN)
 * ②自下而上【对应的操作为下虑】：
 * 思路：将数组的元素依次插入到堆内，全部插入后，对每一个父节点进行下虑操作，从最后一个父节点开始，时间复杂度为O(N)
 *
 *常见的操作：优先队列、堆排序
 *
* */
class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
    }
}
//大根堆
public class Heap {
    private Node root=null;
    private int length=1;
    //获取最后一个父元素
    private Node getLastRoot(){
        if (root==null) return null;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            Node pollNode = queue.poll();
            if (pollNode.leftChild==null||pollNode.rightChild==null) return pollNode;
            if (pollNode.leftChild!=null) queue.add(pollNode.leftChild);
            if (pollNode.rightChild!=null) queue.add(pollNode.rightChild);
        }
        Node tmp=root;
        while(tmp.leftChild!=null){
            tmp=tmp.leftChild;
        }
        return tmp;
    }
    //获取最后一个叶子节点
    private Node getLastLeaf(){
        if (root.leftChild==null&&root.rightChild==null) return root;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()!=0){
            Node pollNode = queue.poll();
            if (pollNode.leftChild!=null) queue.add(pollNode.leftChild);
            if (pollNode.rightChild!=null) queue.add(pollNode.rightChild);
            if (queue.size()==1) return queue.poll();
        }
        return null;
    }
    //按大根堆 插入元素
    public void insertByDagon(int value){
        Node newValue = new Node(value);
        Node lastRoot = getLastRoot();
        if (root==null){
            root=newValue;
            return;
        }
        else if (lastRoot.leftChild==null) lastRoot.leftChild=newValue;
        else lastRoot.rightChild=newValue;
        upperConcern(newValue,true);
        ++length;
    }
    public void insertByRootlet(int value){
        Node newValue = new Node(value);
        Node lastRoot = getLastRoot();
        if (root==null){
            root=newValue;
            return;
        }
        else if (lastRoot.leftChild==null) lastRoot.leftChild=newValue;
        else lastRoot.rightChild=newValue;
        upperConcern(newValue,false);
        ++length;
    }
    //上虑
    private void upperConcern(Node node,boolean flag){
        Node current = node;
        while (current != root) {
            Node parent = getParentNode(current);
            if (flag?current.value > parent.value:current.value < parent.value) {
                // 交换节点值
                int temp = parent.value;
                parent.value = current.value;
                current.value = temp;
            } else {
                break; // 如果不需要交换，则不再上浮
            }
            current = parent; // 继续向上比较
        }
    }
    //下虑
    private void downConcern(Node node){
        Node current = node;
        while (current != null) {
            Node maxChild = getMaxChild(current);
            if (maxChild != null && maxChild.value > current.value) {
                // 交换节点值
                int temp = current.value;
                current.value = maxChild.value;
                maxChild.value = temp;
                current = maxChild;
            } else {
                break; // 不需要交换则退出循环
            }
        }
    }
    private Node getMaxChild(Node node) {
        if (node.leftChild == null && node.rightChild == null) {
            return null;
        } else if (node.rightChild == null || node.leftChild.value > node.rightChild.value) {
            return node.leftChild;
        } else {
            return node.rightChild;
        }
    }
    // 获取节点的父节点
    private Node getParentNode(Node node) {
        if (node == null || node == root) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.leftChild == node || current.rightChild == node) {
                return current;
            }
            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }
        return null;
    }
    //将堆转换成为数组
    public int[] convertToArray(){
        int[] values=new int[length];
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int i=0;
        while (queue.size()!=0){
            Node pollNode = queue.poll();
            values[i] = pollNode.value;
            i++;
            if (pollNode.leftChild!=null) queue.add(pollNode.leftChild);
            if (pollNode.rightChild!=null) queue.add(pollNode.rightChild);
        }
        return values;
    }
    //将数组传话成为堆
    public static Heap convertToHeap(int[] values,boolean flag){
        int size=values.length;
        Heap heap = new Heap();
        for (int i = 0; i < size; i++) {
            if (flag) heap.insertByDagon(values[i]);
            else heap.insertByRootlet(values[i]);
        }
        return heap;
    }
    //堆排序操作    有问题
    public int[] heapSort(){
        int[] values=new int[length];
        for (int i = 0; i < length; i++) {
            values[i]= root.value;
            Node lastLeaf = getLastLeaf();
            if (lastLeaf!=null){
                System.out.println(lastLeaf.value);
//                root.value=lastLeaf.value;
                Node parentNode = getParentNode(lastLeaf);
                if (parentNode==null) continue;
                else if (parentNode.leftChild==lastLeaf) parentNode.leftChild=null;
                else parentNode.rightChild=null;
//                downConcern(root);
            }

        }
        return values;
    }

}
