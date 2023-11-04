package DataStructure.LinearStructure.LinkedList;
/*
* ʵ��һ����ջ
* */
class stackNode<T>{
    T value;
    stackNode<T> next;

    public stackNode(T value, stackNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
public class lqStack<T> {
    stackNode<T> top=null;

    //��ջ
    public lqStack push(T value){
        stackNode<T> newNode = new stackNode<>(value,this.top);
        this.top=newNode;
        return this;
    }
    //��ջ
    public T pop(){
        if (this.top!=null){
            T value = this.top.value;
            this.top=this.top.next;
            return value;
        }else{
            System.out.println("ջ�������");
            return null;
        }
    }
    //�ж���ջ�Ƿ�Ϊ��
    public boolean isEmpty(){
        return this.top==null?true:false;
    }
}
