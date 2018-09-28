package data_structure.stack;

import java.util.LinkedList;

public class MaxStack {
    static LinkedList list;

    public static void main(String[] args) {
        list = new LinkedList();
        push(1);
        push(2);
        push(3);

        System.out.println(pop());
        System.out.println(pop());

    }

    public static void push(int data) {
        list.push(data);
    }

    public static int pop() {
        int pooped = (int) list.getFirst();
        list.removeFirst();
        return pooped;
    }

    public static void max() {

    }
}
