package ToolTest;

import DataStructure.NonlinearStructure.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insertByRootlet(3);
        heap.insertByRootlet(4);
        heap.insertByRootlet(5);
        heap.insertByRootlet(1);
        int[] ints = heap.convertToArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
        System.out.println();
        int[] ints1 = heap.heapSort();
        System.out.println();
        for (int anInt : ints1) {
            System.out.print(anInt+" ");
        }
    }
}
