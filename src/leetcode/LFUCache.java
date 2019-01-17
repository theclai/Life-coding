package leetcode;

import java.util.*;

public class LFUCache {
    //
    HashMap<Integer, Integer> cache;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        // Get the count from counts map
        int count = counts.get(key);
        // increase the counter
        counts.put(key, count + 1);
        // remove the element from the counter to linkedhashset
        lists.get(count).remove(key);

        // when current min does not have any data, next one would be the min
        if (count == min && lists.get(count).size() == 0)
            min++;
        if (!lists.containsKey(count + 1))
            lists.put(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);
        return cache.get(key);
    }

    public void set(int key, int value) {
        if (cap <= 0)
            return;
        if (cache.containsKey(key)) {
            cache.put(key, value);

            get(key);
            return;
        }
        if (cache.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            cache.remove(evit);
            counts.remove(evit);
        }
        cache.put(key, value);

        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
