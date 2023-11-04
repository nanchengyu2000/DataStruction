package ToolTest;

import DataStructure.NonlinearStructure.HashTable;

public class HashTableTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.addvalue(11).addvalue(21).addvalue(13).addvalue(23).addvalue(4).addvalue(10);
        System.out.println(hashTable.containValue(21));
    }
}
