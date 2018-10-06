package strings;

import java.util.HashMap;

public class SuffixTreeOrTrieForPatternMatching {
    private static SuffixTree root;
    public static void main(String[] args) {
         root = new SuffixTree();
        insert("amar");
        System.out.println(search("amarf"));
    }

    private static class SuffixTree {
        char key;
        private HashMap<Character, SuffixTree> map;
        private boolean isLeaf;

        SuffixTree(Character c) {
            this.key = c;
            this.map = new HashMap<>();
        }
        SuffixTree() {
            this.map = new HashMap<>();
        }
    }


    static void insert(String data) {
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
            if (i == data.length() - 1)
                st.isLeaf = true;
        }
    }

    static boolean search(String search) {
        SuffixTree searchNode = searchWord(search);
        if (searchNode != null && searchNode.isLeaf)
            return true;
        else
            return false;
    }

    private static SuffixTree searchWord(String search) {
        SuffixTree st = null;
        HashMap<Character, SuffixTree> map = root.map;
        for (int i = 0; i < search.length(); i++) {
            char c = search.charAt(i);
            if (map.containsKey(c)) {
                st = map.get(c);
                if (st == null)
                    return st;
                map = st.map;

            } else {
                return null;
            }
        }
        return st;
    }

    public boolean startsWith(String prefix) {
        if(searchWord(prefix) == null)
            return false;
        else
            return true;
    }
}
