package strings;

import java.util.HashMap;

public class SuffixTreeOrTrieForPatternMatching {
    public static void main(String[] args) {
        SuffixTree root = new SuffixTree();
        insert("amar", root);
        System.out.println(search("amarf", root));
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


    static SuffixTree insert(String data, SuffixTree root) {
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

        return root;
    }

    static boolean search(String search, SuffixTree root) {
        SuffixTree searchNode = searchWord(search, root);
        if (searchNode != null && searchNode.isLeaf)
            return true;
        else
            return false;
    }

    private static SuffixTree searchWord(String search, SuffixTree root) {
        SuffixTree st = null;
        for (int i = 0; i < search.length(); i++) {
            char c = search.charAt(i);
            HashMap<Character, SuffixTree> map = root.map;
            if (map.containsKey(c)) {
                st = map.get(c);
                if (st == null)
                    return st;
                root = st;

            } else {
                return null;
            }
        }
        return st;
    }

    public boolean startsWith(String prefix,SuffixTree root) {
        if(searchWord(prefix,root) == null)
            return false;
        else
            return true;
    }
}
