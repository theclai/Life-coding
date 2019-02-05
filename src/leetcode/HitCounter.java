package leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HitCounter {
    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
/**
 * ["HitCounter","hit","hit","hit","hit","getHits","hit","getHits","hit","getHits"]
 *  [[],         [1],   [1],  [1], [300],[300],    [300], [300],   [301],[301]]
 * */
        hc.hit(1);
        hc.hit(1);
        hc.hit(1);
        hc.hit(300);

        System.out.println(hc.getHits(300));
        hc.hit(300);
        System.out.println(hc.getHits(300));
        hc.hit(301);
        System.out.println(hc.getHits(301));
        //System.out.println(hc.getHits(302));
        //System.out.println(hc.getHits(303));
        //System.out.println(hc.getHits(304));
        //System.out.println(hc.getHits(600));
    }

    Map<Integer, Integer> map;
    LinkedList<Integer> counter;
    int hits = 0;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        map = new LinkedHashMap<>();
        counter = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        if (map.size() == 0) {
            map.put(timestamp, 1);
            hits++;
            counter.addFirst(timestamp);
        } else {
            if (counter.getFirst() - counter.getLast() >= 300) {
                int last = counter.getLast();
                int val = map.get(last);
                hits -= val;
                map.remove(last);
                counter.removeLast();
            } else {
                counter.addFirst(timestamp);
                hits++;
                map.compute(timestamp, (k, v) -> v==null?1:v + 1);
            }
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (counter.size()!=0 &&timestamp - counter.getLast() >= 300) {
            int data = counter.getLast();
            int val = map.get(data);
            hits -= val;
            counter.removeLast();
            map.remove(data);
        }
        return hits;

    }
}
