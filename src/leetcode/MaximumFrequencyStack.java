package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        MaximumFrequencyStack mfs = new MaximumFrequencyStack();
        mfs.push(1);
        mfs.push(2);
        mfs.push(3);
        mfs.push(1);

        System.out.println(mfs.pop());
        System.out.println(mfs.pop());

//        System.out.println(mfs.queue.getLast());
//
        //      int pos = mfs.queue.lastIndexOf(1);
//        mfs.queue.remove(3);
        //    System.out.println(pos);


    }

    private LinkedList<Integer> queue;
    private HashMap<Integer, Integer> counter;
    private LinkedList<LinkedList<Integer>> frequencyAndItems;// it holds queue of element in the same frequency
    int max = 0;


    public MaximumFrequencyStack() {
        queue = new LinkedList<>();
        counter = new HashMap<>();
        frequencyAndItems = new LinkedList<>();
        LinkedList<Integer> init = new LinkedList<>();
        init.add(Integer.MAX_VALUE);
        frequencyAndItems.add(init);

    }

    public void push(int x) {
        queue.add(x);
        Integer count = counter.get(x);
        if (count == null) {
            count = 1;
            counter.put(x, count);
        } else {
            count = count + 1;
            counter.put(x, count);
        }
        if (count == frequencyAndItems.size()) {
            LinkedList<Integer> a = new LinkedList<>();
            a.add(Integer.MAX_VALUE);
            frequencyAndItems.add(a);
        }
        frequencyAndItems.get(count).add(x);
    }

    public int pop() {
        int size = frequencyAndItems.size() - 1;
        // Get the max frequency
        LinkedList<Integer> maxFrequency = frequencyAndItems.get(size);
        // find the element to remove
        Integer item = maxFrequency.getLast();

        // get the position of the item in the queue
        int index = queue.lastIndexOf(item);
        //remove from the queue
        queue.remove(index);

        //remove the item from the frequency and item queue
        maxFrequency.removeLast();

        if (maxFrequency.size() == 1 & maxFrequency.getLast() == Integer.MAX_VALUE) {
            frequencyAndItems.removeLast();
        }
        return item;

    }
}
