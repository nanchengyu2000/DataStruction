package DataStructure.LinearStructure.LinkedList;

/*
* 循环链表的实现
* */
class Book{
    String bookname;
    int Bookid;

    public Book(String bookname, int bookid) {
        this.bookname = bookname;
        Bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getBookid() {
        return Bookid;
    }

    public void setBookid(int bookid) {
        Bookid = bookid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", Bookid=" + Bookid +
                '}';
    }
}
class LpNode {
    Book book;
    LpNode next;

    public LpNode(Book book, LpNode next) {
        this.book = book;
        this.next = next;
    }

    public void setNext(LpNode next) {
        this.next = next;
    }

    public LpNode getNext() {
        return next;
    }
}
public class LoopLinkList {
    LpNode head;
    LpNode tail;

    //初始化循环列表
    public void initLoopLinkList(){
        this.head=null;
        this.tail=null;
    }
    //向循环链表中添加结点
    public LoopLinkList putNode(String bookname,int booid){
        Book book = new Book(bookname, booid);
        LpNode newNode = new LpNode(book,this.tail);
        if (this.head==null){
            this.head=newNode;
            this.tail=newNode;
        }else{
            this.tail=newNode;
            this.head.setNext(this.tail);
        }
        return this;
    }
    //将第二个循环链表添加到第一个循环链表后
    public void connectTable(LoopLinkList linkList){
        linkList.head.setNext(this.tail);
        this.head.setNext(linkList.tail);
    }
    //打印链表中的数据
    public int printNodeData(){
        LpNode tmppoint=this.head;
        int count=0;
        do {
            System.out.println(tmppoint.book.toString());
            tmppoint=tmppoint.getNext();
            ++count;
        }while (tmppoint!=this.head);
        return count;
    }
}
