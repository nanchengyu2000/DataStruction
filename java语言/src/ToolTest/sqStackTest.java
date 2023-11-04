package ToolTest;

import DataStructure.LinearStructure.SequenceList.sqStack;

public class sqStackTest {
    public static void main(String[] args) {
        sqStack<String> stringsqStack = new sqStack<String>(3);
        stringsqStack.push("huhua").push("sdasd").push("sdasd");
        System.out.println(stringsqStack.pop());
        System.out.println(stringsqStack.pop());
        System.out.println(stringsqStack.pop());
        System.out.println(stringsqStack.pop());
    }
}
