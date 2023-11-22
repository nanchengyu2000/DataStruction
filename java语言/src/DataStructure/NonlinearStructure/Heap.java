package DataStructure.NonlinearStructure;

import java.util.LinkedList;
import java.util.Queue;

/*
* ��Ƶ��û�н����ѣ������ҽ��Զѽ���һ�����
* �ѵĶ��壺
* 1��������һ����ȫ������
* 2�������ԣ� ���Խ��ѷ�Ϊ����
*       ����ѣ�ÿ�����ڵ�Ҫ�������ӽڵ�Ҫ��
*       С���ѣ�ÿ�����ڵ�ҪС�������ӽڵ�
* һ����ʹ��һ����������������
* ��Ϊ����һ����ȫ�������������е�ÿ���ڵ㰴�������������У���ע�±�
* ��Щ�����Ӧ��������水�㼶���ν����Ľڵ��Ž������У��������ܽ�һ����ת����Ϊһ��������
* ��ͼ��֪ ��ǰ�ڵ��±�Ϊi����ڵ���±�Ϊ2i+1,�ҽڵ���±�Ϊ2i+2������������㷨�о���ʹ��
* ��������ת�ѣ���Ҫ�����ѵĻ������������ǣ����ǣ�����Ϊ����ת�ѿ����ƻ��ѵ�����
* ���ǣ�
* �������һ����
*        1
*      /  \
*     7    6
*    / \  / \
*   4  5  1  2
* �����ƻ��ѵ����ʵĽڵ��Ǹ��ڵ㣬1,���մ���ѣ���Ҫ��1����ڵ���ҽڵ�����ֵ���н�������������һ�������ת���ɺϸ�Ķ�
*         7
 *      /  \
 *     5    6
 *    / \  / \
 *   4  1  1  2
 * ���ϵĲ����������ǣ����Ӷ�ΪO(logN)
 * ���ǣ�
 *        7
 *      /  \
 *     5    6
 *    / \  / \
 *   4  1  1  8
 * ֻ�����һ���ڵ��ƻ��˶ѵ����ʣ�8�����մ���ѣ���Ҫ������ڵ��븸�ڵ���н������ڽ�����һ�����������ת����һ���ϸ�Ķ�
 *        8
 *      /  \
 *     5    7
 *    / \  / \
 *   4  1  1  6
 * ���ϵĲ����������ǣ�ʱ�临�Ӷ�Ҳ��O(logN),���������Ҫ������Ԫ�ز��뵽����
 *
 * ���ѣ�
 * ����һ����������飬����ν��ѣ�
 * ���Զ����¡���Ӧ�Ĳ���Ϊ���ǡ���
 *˼·���������е�Ԫ�����β��뵽���ڣ�����һ��Ԫ�غ����һ��У�飬���Ƿ�����Ԫ�ص��¶ѵ����ʱ��ƻ���
 * ����ƻ��ͽ��ýڵ��������   ���Ӷ�ΪO(NlogN)
 * �����¶��ϡ���Ӧ�Ĳ���Ϊ���ǡ���
 * ˼·���������Ԫ�����β��뵽���ڣ�ȫ������󣬶�ÿһ�����ڵ�������ǲ����������һ�����ڵ㿪ʼ��ʱ�临�Ӷ�ΪO(N)
 *
 *�����Ĳ��������ȶ��С�������
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
//�����
public class Heap {
    private Node root=null;
    private int length=1;
    //��ȡ���һ����Ԫ��
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
    //��ȡ���һ��Ҷ�ӽڵ�
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
    //������� ����Ԫ��
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
    //����
    private void upperConcern(Node node,boolean flag){
        Node current = node;
        while (current != root) {
            Node parent = getParentNode(current);
            if (flag?current.value > parent.value:current.value < parent.value) {
                // �����ڵ�ֵ
                int temp = parent.value;
                parent.value = current.value;
                current.value = temp;
            } else {
                break; // �������Ҫ�����������ϸ�
            }
            current = parent; // �������ϱȽ�
        }
    }
    //����
    private void downConcern(Node node){
        Node current = node;
        while (current != null) {
            Node maxChild = getMaxChild(current);
            if (maxChild != null && maxChild.value > current.value) {
                // �����ڵ�ֵ
                int temp = current.value;
                current.value = maxChild.value;
                maxChild.value = temp;
                current = maxChild;
            } else {
                break; // ����Ҫ�������˳�ѭ��
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
    // ��ȡ�ڵ�ĸ��ڵ�
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
    //����ת����Ϊ����
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
    //�����鴫����Ϊ��
    public static Heap convertToHeap(int[] values,boolean flag){
        int size=values.length;
        Heap heap = new Heap();
        for (int i = 0; i < size; i++) {
            if (flag) heap.insertByDagon(values[i]);
            else heap.insertByRootlet(values[i]);
        }
        return heap;
    }
    //���������    ������
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
