package dailycodings;

import java.util.ArrayList;
import java.util.List;

public class ThreeStackFromOneList_141 {
    public static class Item {
        int val;
        int next;

        public Item(int item, int next) {
            this.val = item;
            this.next = next;
        }
    }

    static List<Item> list;
    private static int firstStack = -1;
    private static int secondStack = -1;
    private static int thirdStack = -1;

    public static void main(String[] args) {
        list = new ArrayList<>();
        push(201,2);
        push(202,2);
        push(101,1);
        push(301,3);
        System.out.println(pop(2));
        System.out.println(pop(2));

        System.out.println(pop(3));
        System.out.println(pop(3));

    }

    public static void push(int item, int stackNumber) {
        if (stackNumber == 1) {
            int pos = insert(item, firstStack);
            firstStack = pos;
        } else if (stackNumber == 2) {
            secondStack = insert(item, secondStack);
        } else {
            thirdStack = insert(item, thirdStack);
        }
    }

    public static int pop(int stack) {
        Item popped;
        if (stack == 1) {
            if (firstStack == -1) return Integer.MIN_VALUE;
            popped = list.get(firstStack);
            firstStack = popped.next;
            return popped.val;
        } else if (stack == 2) {
            if (secondStack == -1) return Integer.MIN_VALUE;
            popped = list.get(secondStack);
            secondStack = popped.next;
            return popped.val;
        } else {
            if (thirdStack == -1) return Integer.MIN_VALUE;
            popped = list.get(thirdStack);
            thirdStack = popped.next;
            return popped.val;
        }
    }

    private static int insert(int item, int stackNumber) {
        Item itm = new Item(item, stackNumber);
        //add to list
        list.add(itm);
        return list.size() - 1;
    }
}
