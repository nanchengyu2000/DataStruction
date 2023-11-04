package DataStructure.NonlinearStructure;

/*
* 采用开放寻址法实现哈希表
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
    //获取索引，-2:该元素已经无法插入，-1:非法值
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
    //向哈希表中插入数据
    public HashOpenTable addvalue(int value){
        int key=getKey(value);
        if (key==-1){
            System.out.println("非法值的输入");
        }else if (key==-2){
            System.out.println("此数值不能插入哈希表！");
        }else {
            values[key]=value;
        }
        return this;
    }
    //查看哈希表中是否包含某值
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
