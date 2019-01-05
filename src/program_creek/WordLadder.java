package program_creek;

import java.util.*;

public class WordLadder {
    static HashSet<String> set;
    static HashSet<Character> chars;

    public static void main(String[] args) {
        set = new HashSet();
        chars = new HashSet();
        String[] strings = new String[]{"hot", "dot", "dog", "lot", "log","cog"};
        Arrays.stream(strings)
                .forEach(word -> {
                    set.add(word);
                    word.chars()
                            .mapToObj(c -> (char) c)
                            .forEach(v -> chars.add(v));
                });
        chars.forEach(character -> System.out.println(character));
        System.out.println(ladderLength("hit", "cog", Arrays.asList(strings)));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Deque<String> deque = new ArrayDeque();
        deque.addLast(beginWord);
        int len = 0;
        Set<String> words = new HashSet<>(wordList);
        while (!deque.isEmpty()) {
            len++;
            String word = deque.removeFirst();
            if (endWord.equals(word))
                return len;
            List<String> candidates = getCandidates(words, word);
            for (String candidate : candidates) {
                if (candidate.equals(endWord)) return len;
                deque.addLast(candidate);
            }
        }
        return 0;
    }

    private static List<String> getCandidates(Set<String> words, String word) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) {
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (words.remove(newWord)) {
                    candidates.add(newWord);
                }
            }
            sb.setCharAt(i, temp);
        }
        return candidates;
    }


}
