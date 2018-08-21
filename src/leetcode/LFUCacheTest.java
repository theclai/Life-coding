package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LFUCacheTest {
    static LFUCache cache;

    public LFUCacheTest() {
        cache = new LFUCache(5);
    }

    @Test
    public void testFirst(){
        cache.set(1, 1);
        cache.set(2, 2);
        Assertions.assertEquals(1,cache.get(1));
    }
    @Test
    public void testSecond(){
        cache.set(3, 3);    // evicts key 2
        Assertions.assertEquals(-1,cache.get(2));
        Assertions.assertEquals(3,cache.get(3));      // returns 3.
    }

}
