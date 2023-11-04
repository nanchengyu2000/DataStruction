package DataStructure.LinearStructure.LinkedList;

/*
*带头节点的双链表实现
* */
class User{
    String username;
    int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
class doNode{
    User data;
    private doNode next;
    private doNode pre;

    public doNode(User user, doNode next,doNode pre) {
        this.data = user;
        this.next = next;
        this.pre=pre;
    }

    public doNode() {
    }

    public doNode getNext() {
        return next;
    }

    public doNode getPre() {
        return pre;
    }

    public void setNext(doNode next) {
        this.next = next;
    }
    public void setPre(doNode pre){
        this.pre=pre;
    }
}

public class doLinkList {
    private doNode node;
    private doNode cruNode;
    //初始化链表
    public void initDoLinkList(){
        doNode doNode = new doNode();
        node=doNode;
        cruNode=doNode;
    }
    //向链表添加结点
    public doLinkList putNode(String username,int age){
        User user = new User(username, age);
        doNode doNode = new doNode(user,null,cruNode);
        cruNode.setNext(doNode);
        cruNode=doNode;
        return this;
    }
    //打印结点数据
    public void printNodeData(){
        if (node.getNext()==null){
            System.out.println("链表为空");
            return;
        }else{
            doNode NodePointer=node.getNext();
            while (NodePointer!=null){
                User user=NodePointer.data;
                System.out.println(user.toString());
                NodePointer=NodePointer.getNext();
            }
        }
    }
    //删除链表结点
    public void delNode(int i){
        doNode node=this.node.getNext();
        doNode preNode=this.node;
        int count=1;
        while(node!=null){
            if (count==i){
                preNode.setNext(node.getNext());
                node.getNext().setPre(preNode);
            }
            ++count;
            preNode=node;
            node=node.getNext();
        }
    }
    //向双向节点中插入结点（末尾节点不可以插入）
    public void insertNode(String username, int age,int i){
        User user = new User(username, age);
        doNode newNode = new doNode(user,null,null);
        doNode preNode=this.node;
        doNode creNode=preNode.getNext();
        int count=1;
        while (creNode!=null){
            if (count==i){
                creNode.setPre(newNode);
                newNode.setPre(preNode);
                preNode.setNext(newNode);
                newNode.setNext(creNode);
                return;
            }
            preNode=creNode;
            creNode=cruNode.getNext();
            ++count;
        }
        if (creNode==null){
            System.out.println("并不能在末尾节点不可以插入");
        }
    }
}
