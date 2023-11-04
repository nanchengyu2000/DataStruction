package DataStructure.LinearStructure.SequenceList;
/*
* ʵ��һ��˳��ջ
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
    //ѹջ����
    public sqStack<T> push(T value){
        if (this.top-this.base!=stackArray.length){
            stackArray[this.top]=value;
            ++this.top;
        }else{
            System.out.println("��ջ������");
        }
        return this;
    }
    //��ջ����
    public T pop(){
        if (this.top==this.base){
            System.out.println("�����������");
            return null;
        }
        return  stackArray[--this.top];
    }
    //�ж�ջ�Ƿ�Ϊ��
    public boolean isEmpty(){
        return this.base==this.top?true:false;
    }
    //��ȡջ�Ĵ�С
    public int getSize(){
        return this.top-this.base;
    }
    //���ջ
    public void clearStack(){
        this.top=this.base;
    }
}
