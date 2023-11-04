package DataStructure.LinearStructure.SequenceList;

/*
* 实现一个顺序队列
* */

public class SqQueue<T> {
    T h[];
    int front;
    int tail;
    int size;

    public SqQueue(int size) {
        this.size = size;
        this.h=(T[]) new Object[size];
    }
    //入队
    public SqQueue<T> enqueue(T value){
        if ((tail+1)%size==this.front){
            System.out.println("栈满操作");
            return null;
        }else{
            this.h[tail]=value;
            tail=(tail+1)%size;
            return this;
        }
    }
    //出队
    public T dequeue(){
        if (tail!=front){
//            System.out.println(h[front]);
            int temp;
            temp=front;
            front=(front+1)%size;
            return h[temp];
        }else{
            System.out.println("空队列操作!");
            return null;
        }
    }
    public int getSize(){
        return (tail-front+size)%size;
    }
}
