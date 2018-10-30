package data_compression;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 1. HE is a variable length encoding
 * 2. Prefix free Trie, to avoid collision or mess
 * 3. Loss less compression
 */
public class HuffmanEncoding {
    HashMap<Character, Integer> map = new HashMap<>();

    public void HuffmanEncodingBuilder(String data) {
        // create frequency counter
        data.chars().forEach(c->{
            if(map.containsKey((char)c))
                map.put((char)c,map.get((char)c)+1);
            else
                map.put((char)c,1);
        });

        printFrequencyCounter(map);

    }

    private void printFrequencyCounter(HashMap<Character, Integer> map) {
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e= (Map.Entry) it.next();
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }

    public static void main(String[] args) {
        HuffmanEncoding he=new HuffmanEncoding();
        he.HuffmanEncodingBuilder("HelloHell");
    }

}
