package strings;

import java.util.HashMap;

public class SuffixTreeOrTrieForPatternMatching {
    public static void main(String[] args) {
        SuffixTree root=new SuffixTree('*');
        insert("amar",root);
    }

    private static class SuffixTree {
        char key;
        public HashMap<Character, SuffixTree> map;

        SuffixTree(Character c) {
            this.key = c;
            map = new HashMap<>();
        }
    }


    public static void insert(String data, SuffixTree root) {
        char[] chars = data.toCharArray();
        HashMap<Character, SuffixTree> map = root.map;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                map = map.get(c).map;
                //map = root.map;
            } else {
                map.put(c, new SuffixTree(c));

            }
        }
    }
}
