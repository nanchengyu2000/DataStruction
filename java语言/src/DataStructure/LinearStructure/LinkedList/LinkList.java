package DataStructure.LinearStructure.LinkedList;

/*
* 带头节点单链表的实现
* */
class Data{
    String username;
    int age;

    public Data(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Data{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
class Node{

    Data data;
    private Node next;

    public Node(Data data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class LinkList {
    private Node node;
    private Node cruNode;
    //初始化一个链表
    public void init(){
        Node node=new Node();
         this.node=node;
         this.cruNode=node;
    }
    //尾结点插入
    public LinkList putNodeByTail(String username,int age){
        Data data = new Data(username,age);
        Node newNode=new Node(data,null);
        cruNode.setNext(newNode);
        cruNode=newNode;
        return this;
    }
    //头节点插入
    public void putNodeByHead(String username,int age){
        Data data = new Data(username,age);
        Node newNode=new Node(data,null);
        if (node!=null){
            Node tmp=node.getNext();
            newNode.setNext(tmp);
            node.setNext(newNode);
        }
    }
    //删除其中一个结点
    public void deleteNode(int i){
        if (i==1){
            Node next = node.getNext().getNext();
            node.setNext(next);
        }else {
            int count=2;
            Node froNode=node.getNext();
            Node preNode=node.getNext().getNext();
            while (preNode!=null){
                if (count==i){
                    froNode.setNext(preNode.getNext());
                }
                froNode=preNode;
                preNode=preNode.getNext();
                ++count;
            }
        }
    }
    //向链表中插入元素
    public void insertNode(int i,String username,int age){
        Data data = new Data(username, age);
        Node newNode = new Node(data, null);
        int count=1;
        Node preNode=node.getNext();
        Node froNode=null;
        while (preNode!=null){
            if (count==i){
                froNode.setNext(newNode);
                newNode.setNext(preNode);
            }
            froNode=preNode;
            preNode=preNode.getNext();
            ++count;
        }
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return node.getNext()!=null?false:true;
    }
    //获取第i个结点
    public Node getNode(int i){
        Node countNode=node.getNext();
        int count=1;
        while (countNode!=null){
            if (count==i){
                return countNode;
            }
            countNode=countNode.getNext();
            ++count;
        }
        if (countNode==null) return null;
        return countNode;
    }

    //打印链表中的数据
    public void printNodeData(){
        Node preNode=node.getNext();
        while (preNode!=null){
            System.out.println(preNode.data.toString());
            preNode=preNode.getNext();
        }
    }
}

