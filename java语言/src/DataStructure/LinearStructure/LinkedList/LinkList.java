package DataStructure.LinearStructure.LinkedList;

/*
* ��ͷ�ڵ㵥�����ʵ��
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
    //��ʼ��һ������
    public void init(){
        Node node=new Node();
         this.node=node;
         this.cruNode=node;
    }
    //β������
    public LinkList putNodeByTail(String username,int age){
        Data data = new Data(username,age);
        Node newNode=new Node(data,null);
        cruNode.setNext(newNode);
        cruNode=newNode;
        return this;
    }
    //ͷ�ڵ����
    public void putNodeByHead(String username,int age){
        Data data = new Data(username,age);
        Node newNode=new Node(data,null);
        if (node!=null){
            Node tmp=node.getNext();
            newNode.setNext(tmp);
            node.setNext(newNode);
        }
    }
    //ɾ������һ�����
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
    //�������в���Ԫ��
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
    //�ж������Ƿ�Ϊ��
    public boolean isEmpty(){
        return node.getNext()!=null?false:true;
    }
    //��ȡ��i�����
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

    //��ӡ�����е�����
    public void printNodeData(){
        Node preNode=node.getNext();
        while (preNode!=null){
            System.out.println(preNode.data.toString());
            preNode=preNode.getNext();
        }
    }
}

