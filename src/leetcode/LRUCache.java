package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int size;

    public LRUCache(int size) {
        this.size = size;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            value=-1;
        }else{
            this.set(key,value);
        }
        return value;

    }

    private void set(int key,int val) {
        if(this.map.containsKey(key)){
            this.map.remove(key);
        }else if(this.map.size()==this.size){
            Iterator<Integer> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key,val);
    }

    public void put(int key, int value) {
        this.set(key,value);


    }
}
