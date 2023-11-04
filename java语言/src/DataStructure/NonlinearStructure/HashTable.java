package DataStructure.NonlinearStructure;

/*
* ��������ַ��ʵ�ֹ�ϣ��
* */
class HashNode{
    int value;
    HashNode next;

    public HashNode(int value, HashNode next) {
        this.value = value;
        this.next = next;
    }
}
public class HashTable {
        HashNode hashNodes[];
        int size;

        public HashTable(int size) {
            this.size=size;
            this.hashNodes = new HashNode[size];
            for (int i = 0; i < size; i++) {
                hashNodes[i]=null;
            }
        }
       public int getKey(int value){
            return value%size;
        }
       //���ϣ���в�������
       public HashTable addvalue(int value){
           int key = getKey(value);
           HashNode newNode = new HashNode(value, null);
           if (hashNodes[key]!=null){
               HashNode curNode=hashNodes[key];
               while (curNode.next!=null){
                   curNode=curNode.next;
               };
               curNode.next=newNode;
           }else{
               hashNodes[key]=newNode;
           }
           return this;
       }
       //�Ƿ����ĳֵ
       public boolean containValue(int value){
           int key = getKey(value);
           if (hashNodes[key]==null){
               return false;
           }else{
               HashNode curNode=hashNodes[key];
               while (curNode!=null&&curNode.value!=value){
                   curNode=curNode.next;
               }
               return curNode!=null?true:false;
           }
       }
}
