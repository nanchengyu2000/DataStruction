package ToolTest;

import DataStructure.LinearStructure.LinkedList.LinkList;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.init();
        linkList.putNodeByTail("zhangshan",10).putNodeByTail("lishi",20)
                .putNodeByTail("wangwu",21).putNodeByHead("qianmian",70);
        System.out.println(linkList.isEmpty());
        linkList.printNodeData();
        linkList.deleteNode(2);
        System.out.println("--------------");
        linkList.printNodeData();
        System.out.println("--------------");
        linkList.insertNode(2,"222",11);
        linkList.printNodeData();
    }
}
