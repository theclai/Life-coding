package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWords {
    //https://leetcode.com/contest/weekly-contest-97/problems/uncommon-words-from-two-sentences/

    public static void main(String[] args){
        String[] array= uncommonFromSentences("this apple is sweet",
                "this apple is sour");

    }
    public static String[] uncommonFromSentences(String A, String B) {

        HashMap<String,Integer> map = new HashMap<>();
        String[] wordsA = A.split("\\s+");
        String[] wordsB = B.split("\\s+");
        List<String> result = new ArrayList<>();

        for(String word:wordsA){
            if(map.get(word)==null){
                map.put(word,1);
            }else{
                int counter = map.get(word);
                counter=counter+1;
                map.put(word,counter);
            }
        }

        for(String w:wordsB){
            if(map.get(w)==null){
                map.put(w,1);
            }else{
                int counter = map.get(w);
                counter=counter+1;
                map.put(w,counter);
            }
        }

        for(Map.Entry e:map.entrySet()){
           if(e.getValue()==Integer.valueOf(1)){
               System.out.println(e.getKey());
               result.add(String.valueOf(e.getKey()));

           }

        }

        String[] array = new String[result.size()];
        int i=0;
        for(String s:result){
            array[i]=s;
            i++;
        }
return array;
    }
}
