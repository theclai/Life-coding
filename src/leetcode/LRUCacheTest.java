package leetcode;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {
    LRUCache cache;
    public LRUCacheTest(){
        this.cache =new LRUCache(2);
    }
    @Test
    public void putTest1(){
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
    }

    @Test
    public void putTest2(){
        cache.put(3, 3);    // evicts key 2
        cache.get(2);
    }

    @Test
    public void putTest3(){
        cache.put(4, 4);    // evicts key 1
        cache.get(1);
    }

    @Test
    public void putTest4(){
        cache.get(3);       // returns 3
        cache.get(4);
    }
}
