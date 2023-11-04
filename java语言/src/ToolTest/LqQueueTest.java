package ToolTest;

import DataStructure.LinearStructure.LinkedList.LqQueue;

public class LqQueueTest {
    public static void main(String[] args) {
        LqQueue lqQueue = new LqQueue();
        lqQueue.enqueue("asd").enqueue("kkk").enqueue("ppp");
        lqQueue.dequeue();
        lqQueue.dequeue();
        lqQueue.dequeue();
        lqQueue.dequeue();
    }
}
