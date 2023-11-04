package DataStructure.LinearStructure.SequenceList;
/*
* 实现一个顺序栈
* */
public class sqStack<T> {
    private int top;
    private int base;
    private T[] stackArray;

    public sqStack(int stackSize) {
        this.top =0;
        this.base =0;
        stackArray=(T[]) new Object[stackSize];
    }
    //压栈操作
    public sqStack<T> push(T value){
        if (this.top-this.base!=stackArray.length){
            stackArray[this.top]=value;
            ++this.top;
        }else{
            System.out.println("满栈操作！");
        }
        return this;
    }
    //出栈操作
    public T pop(){
        if (this.top==this.base){
            System.out.println("下溢出操作！");
            return null;
        }
        return  stackArray[--this.top];
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return this.base==this.top?true:false;
    }
    //获取栈的大小
    public int getSize(){
        return this.top-this.base;
    }
    //清空栈
    public void clearStack(){
        this.top=this.base;
    }
}
