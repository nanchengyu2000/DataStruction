package DataStructure.LinearStructure.LinkedList;
/*
* 链表队列的实现
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

    //入队
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

    //出队
    public void dequeue(){
        if (front==null){
            System.out.println("空队列操作！");
        }else{
            System.out.println(front.value);
            front=front.next;
        }
    }
}
