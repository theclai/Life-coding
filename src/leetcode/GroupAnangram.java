package leetcode;

import java.util.*;

public class GroupAnangram {
    public static void main(String[] args) {
        GroupAnangram ga=new GroupAnangram();
        String[] input1= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        ga.groupAnagrams(input1);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();

        for(String str:strs){
            char[] c= str.toCharArray();
            Arrays.sort(c);

            map.computeIfAbsent(String.valueOf(c),val->new ArrayList<>()).add(str);
        }
        System.out.println(map);
        List<List<String>> res=new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> data:map.entrySet()){
            res.add(data.getValue());
        }
        return  res;

    }
}
