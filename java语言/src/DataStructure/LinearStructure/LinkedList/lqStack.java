package DataStructure.LinearStructure.LinkedList;
/*
* 实现一个链栈
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

    //入栈
    public lqStack push(T value){
        stackNode<T> newNode = new stackNode<>(value,this.top);
        this.top=newNode;
        return this;
    }
    //出栈
    public T pop(){
        if (this.top!=null){
            T value = this.top.value;
            this.top=this.top.next;
            return value;
        }else{
            System.out.println("栈下溢出！");
            return null;
        }
    }
    //判断链栈是否为空
    public boolean isEmpty(){
        return this.top==null?true:false;
    }
}
