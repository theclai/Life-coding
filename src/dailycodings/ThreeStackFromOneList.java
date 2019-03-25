package dailycodings;

import java.util.ArrayList;
import java.util.List;

public class ThreeStackFromOneList {
    public static class Item {
        int val;
        int next;

        public Item(int item, int next) {
            this.val = item;
            this.next = next;
        }
    }

    static List<Item> list;
    private int firstStack = -1;
    private int secondStack = -1;
    private int thirdStack = -1;

    public static void main(String[] args) {
        list = new ArrayList<>();

    }

    public void push(int item, int stackNumber) {
        if (stackNumber == 1) {
            int pos = insert(item, firstStack);
            firstStack = pos;
        } else if (stackNumber == 2) {
            secondStack = insert(item, secondStack);
        } else {
            thirdStack = insert(item, thirdStack);
        }
    }

    public int pop(int stack) {
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

    private int insert(int item, int stackNumber) {
        Item itm = new Item(item, stackNumber);
        //add to list
        list.add(itm);
        return list.size() - 1;
    }
}
