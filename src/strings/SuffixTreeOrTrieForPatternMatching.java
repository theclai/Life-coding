package strings;

import java.util.HashMap;

public class SuffixTreeOrTrieForPatternMatching {
    public static void main(String[] args) {
        SuffixTree root = new SuffixTree();
        insert("amar", root);
    }

    private static class SuffixTree {
        char key;
        private HashMap<Character, SuffixTree> map;
        private boolean isLeaf;
        SuffixTree(Character c) {
            this.key = c;
            this.map = new HashMap<>();
        }
        SuffixTree(){
            this.map=new HashMap<>();
        }
    }


    public static SuffixTree insert(String data, SuffixTree root) {
        char[] chars = data.toCharArray();
        HashMap<Character, SuffixTree> map = root.map;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            SuffixTree st;
            if (map.containsKey(c)) {
                st = map.get(c);
            } else {
                st = new SuffixTree(c);
                map.put(c, st);
            }
            map = st.map;

            //set leaf node
            if(i==data.length()-1)
                st.isLeaf = true;
        }

        return root;
    }
}
