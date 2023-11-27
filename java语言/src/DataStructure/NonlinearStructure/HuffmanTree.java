package DataStructure.NonlinearStructure;


import java.util.*;

/*
* 设计哈夫曼树
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
    private void builder(){
        for (int i = 0; i < trees.size(); i+=2) {
            HuffmanNode min1 = getMin(i);  //这样很慢，每次进行获取最小的两个数时都需要进行排序，可更改
            HuffmanNode min2 =getMin(i+1);
            HuffmanNode newNode = new HuffmanNode(-1, min2.weight + min1.weight);
            newNode.left=min1;
            newNode.right=min2;
            delete(i,i+1);
            trees.add(newNode);
        }
    }
    public void delete(int min1,int min2){
        trees.remove(min1);
        trees.remove(min2);
    }
    public HuffmanNode getMin(int index){
        trees.sort( new compare());
        return trees.get(index);
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

