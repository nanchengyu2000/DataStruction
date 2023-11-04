package DataStructure.NonlinearStructure;

/*
* ���ÿ���Ѱַ��ʵ�ֹ�ϣ��
* */
public class HashOpenTable{
    int values[];
    int size;

    public HashOpenTable(int size) {
        this.size=size;
        values=new int[size];
        for (int i = 0; i < size; i++) {
            values[i]=-1;
        }
    }
    //��ȡ������-2:��Ԫ���Ѿ��޷����룬-1:�Ƿ�ֵ
    public int getKey(int value){
        int key=value%this.size;
        if (key>=0&&values[key]!=-1){
            for (int i = key+1; i < size; i++) {
                if (values[i]==-1) return i;
            }
            return -2;
        }else if (values[key]==-1){
            return key;
        }else {
           return -1;
        }
    }
    //���ϣ���в�������
    public HashOpenTable addvalue(int value){
        int key=getKey(value);
        if (key==-1){
            System.out.println("�Ƿ�ֵ������");
        }else if (key==-2){
            System.out.println("����ֵ���ܲ����ϣ��");
        }else {
            values[key]=value;
        }
        return this;
    }
    //�鿴��ϣ�����Ƿ����ĳֵ
    public boolean containValue(int value){
        int key=value%this.size;
        if (key==-1)
            return false;
        else{
            for (int i = key; i < size; i++) {
                if (values[i]==value) return true;
            }
            return false;
        }
    }
}
