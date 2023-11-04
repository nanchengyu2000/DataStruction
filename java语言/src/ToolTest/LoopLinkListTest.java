package ToolTest;

import DataStructure.LinearStructure.LinkedList.LoopLinkList;

public class LoopLinkListTest {
    public static void main(String[] args) {
        LoopLinkList loopLinkList = new LoopLinkList();
        loopLinkList.initLoopLinkList();
        loopLinkList.putNode("java»ÎÕ¡",10).putNode("php",1).putNode("kl",10);
        loopLinkList.printNodeData();
        System.out.println("--------------");
        LoopLinkList loopLinkList1 = new LoopLinkList();
        loopLinkList1.putNode("lp",00).putNode("kk",10);
        loopLinkList.connectTable(loopLinkList1);
        loopLinkList.printNodeData();
    }
}
