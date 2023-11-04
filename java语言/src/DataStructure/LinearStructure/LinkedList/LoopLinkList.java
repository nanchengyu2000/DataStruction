package DataStructure.LinearStructure.LinkedList;

/*
* ѭ�������ʵ��
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

    //��ʼ��ѭ���б�
    public void initLoopLinkList(){
        this.head=null;
        this.tail=null;
    }
    //��ѭ����������ӽ��
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
    //���ڶ���ѭ��������ӵ���һ��ѭ�������
    public void connectTable(LoopLinkList linkList){
        linkList.head.setNext(this.tail);
        this.head.setNext(linkList.tail);
    }
    //��ӡ�����е�����
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
