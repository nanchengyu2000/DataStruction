package DataStructure.LinearStructure.SequenceList;

/*
* ʵ��һ��˳�����
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
    //���
    public SqQueue<T> enqueue(T value){
        if ((tail+1)%size==this.front){
            System.out.println("ջ������");
            return null;
        }else{
            this.h[tail]=value;
            tail=(tail+1)%size;
            return this;
        }
    }
    //����
    public T dequeue(){
        if (tail!=front){
//            System.out.println(h[front]);
            int temp;
            temp=front;
            front=(front+1)%size;
            return h[temp];
        }else{
            System.out.println("�ն��в���!");
            return null;
        }
    }
    public int getSize(){
        return (tail-front+size)%size;
    }
}
