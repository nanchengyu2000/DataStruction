package ToolTest;

import DataStructure.LinearStructure.LinkedList.lqStack;

public class lqStackTest {
    public static void main(String[] args) {
        lqStack<String> Stack = new lqStack<>();
        System.out.println(Stack.isEmpty());
        Stack.push("asas").push("asda").push("ASdsa");
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
    }
}
