package ToolTest;

import DataStructure.NonlinearStructure.HashOpenTable;

public class HashOpenTableTest {
    public static void main(String[] args) {
        HashOpenTable hashOpenTable = new HashOpenTable(10);
        hashOpenTable.addvalue(1).addvalue(2).addvalue(4).addvalue(12).addvalue(14);
        System.out.println(hashOpenTable.containValue(12));
    }
}
