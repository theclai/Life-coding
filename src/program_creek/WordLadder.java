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
        // check edge case
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        // build queue, visited set
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> words = new HashSet<>(wordList);

        // process one level of queue each time, count
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> candidates = transform(words, word);
                for (String candidate: candidates) {
                    if (endWord.equals(candidate)) {
                        return count;
                    }
                    queue.offer(candidate);
                }
            }
        }// END WHILE

        return 0;
    }

    // switch each char with 26 lowercase letters, and return candidates
    private static List<String> transform(Set<String> words, String word) {
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
