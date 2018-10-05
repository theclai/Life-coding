package strings;

import java.util.HashMap;

public class SuffixTreeOrTrieForPatternMatching {
    private class SuffixTrie {
        char key;
        public HashMap<Character, SuffixTrie> map;

        SuffixTrie(Character c) {
            this.key = c;
            map = new HashMap<>();
        }
    }


    public void insert(String data, SuffixTrie root) {
        char[] chars = data.toCharArray();
        HashMap<Character, SuffixTrie> map = root.map;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                root = map.get(c);
                map = root.map;
            } else {
                root.map.put(c, new SuffixTrie(c));
            }

        }


    }
}
