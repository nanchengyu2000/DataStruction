package ToolTest;

import DataStructure.NonlinearStructure.HuffmanTree;

public class HuffmanTreeTest {
    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.add(10,2);
        huffmanTree.add(0,6);
        huffmanTree.add(1,4);
        huffmanTree.add(7,5);
        huffmanTree.add(8,7);
        huffmanTree.builder();
    }
}
