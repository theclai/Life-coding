package leetcode;

public class LFUMain {
    public static void main(String[] args){
        LFUCache cache=new LFUCache(2);
        cache.set(1, 1);
        //cache.set(2, 2);
        cache.set(1, 1);
        cache.set(1, 1);
        cache.set(3, 3);
        cache.get(3);
        System.out.println(cache.get(3));
    }

}
