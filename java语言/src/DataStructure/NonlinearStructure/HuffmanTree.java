package DataStructure.NonlinearStructure;


import DataStructure.LinearStructure.SequenceList.SqQueue;

import java.util.*;

/*
* Éè¼Æ¹þ·òÂüÊ÷
* */
class HuffmanNode{
    int value;
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int value,int weight) {
        this.value = value;
        this.weight=weight;
    }
}
public class HuffmanTree {
    LinkedList<HuffmanNode> trees;
    int index=0;
    ArrayList<HuffmanNode> r=new ArrayList<>();
    public HuffmanTree() {
        trees=new LinkedList<>();
    }
    public void add(int value,int weight){
        trees.add(new HuffmanNode(value,weight));
    }
    public void builder(){
        int size=trees.size();
        trees.sort( new compare());
        for (int i = 0; i < size-1; i++) {
            trees.sort( new compare());
            HuffmanNode min1 = trees.get(0);
            HuffmanNode min2 =trees.get(1);
            HuffmanNode newNode = new HuffmanNode(-1, min2.weight + min1.weight);
            newNode.left=min1;
            newNode.right=min2;
            delete();
            trees.add(newNode);
        }
    }
    public void delete(){
        trees.remove(0);
        trees.remove(0);
    }
    private void levelTraverse(HuffmanNode Root){
        if (Root==null) return;
        else {
            SqQueue<HuffmanNode> SqQueue = new SqQueue<>(100);
            SqQueue.enqueue(Root);
            while (SqQueue.getSize()!=0){
                HuffmanNode deNode = SqQueue.dequeue();
                System.out.print(deNode.value+" ");
                if (deNode.left!=null)
                    SqQueue.enqueue(deNode.left);
                if (deNode.right!=null)
                    SqQueue.enqueue(deNode.right);
            }
        }
    }
    public void levelTraverse(){
        levelTraverse(this.trees.get(0));
    }
}
class compare implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        if (o1.weight>o2.weight) return 1;
        else if (o1.weight<o2.weight) return -1;
        else return 0;
    }
}

