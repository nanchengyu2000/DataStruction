package ToolTest;

import DataStructure.LinearStructure.LinkedList.doLinkList;

public class DoLinkListTest {
    public static void main(String[] args) {
        doLinkList doLinkList = new doLinkList();
        doLinkList.initDoLinkList();
        doLinkList.putNode("zhangshan",10).putNode("lishi",20).putNode("wangwu",21);
        doLinkList.delNode(1);
        doLinkList.insertNode("lihua",20,2);
        doLinkList.printNodeData();
    }
}
