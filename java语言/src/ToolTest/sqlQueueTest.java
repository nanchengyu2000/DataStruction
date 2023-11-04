package ToolTest;

import DataStructure.LinearStructure.SequenceList.SqQueue;

public class sqlQueueTest {
    public static void main(String[] args) {
        SqQueue<String> SqQueue = new SqQueue<>(6);
        SqQueue.enqueue("sad").enqueue("asda").enqueue("SAda");
        SqQueue.dequeue();
        SqQueue.dequeue();
//        SqQueue.dequeue();
        System.out.println(SqQueue.getSize());
    }
}
