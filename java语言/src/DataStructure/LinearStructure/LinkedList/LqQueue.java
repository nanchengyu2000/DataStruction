package DataStructure.LinearStructure.LinkedList;
/*
* ������е�ʵ��
* */
class lqSqNode<T>{
    T value;
    lqSqNode<T> next;

    public lqSqNode(T value, lqSqNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
public class LqQueue<T> {
    lqSqNode<T> front;
    lqSqNode<T> tail;

    public LqQueue() {
        this.front=null;
        this.tail=null;
    }

    //���
    public LqQueue<T> enqueue(T value){
        lqSqNode newNode=new lqSqNode(value,null);
        if (front==null){
            front=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        return this;
    }

    //����
    public void dequeue(){
        if (front==null){
            System.out.println("�ն��в�����");
        }else{
            System.out.println(front.value);
            front=front.next;
        }
    }
}
