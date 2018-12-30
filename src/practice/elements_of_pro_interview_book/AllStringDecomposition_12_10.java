package practice.elements_of_pro_interview_book;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllStringDecomposition_12_10 {
    public static void main(String[] args) {
        findAllSubstrings("amanaplanaacanal", Arrays.asList("can", "apl", "ana"));
    }

    public static List<Integer> findAllSubstrings(String s, List<String> words) {
        Map<String, Long> wordToFreq = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int unitSize = words.get(0).length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i + unitSize * words.size() < s.length(); ++i) {
            if (matchAllWordsInDict(s, wordToFreq, i, words.size(), unitSize)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean matchAllWordsInDict(String s,
                                               Map<String, Long> wordToFreq,
                                               int start,
                                               int numWords,
                                               int unitSize) {
        Map<String, Integer> currStringToFreq = new HashMap<>();
        for (int i = 0; i < numWords; ++i) {
            String currWord = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
            Long freq = wordToFreq.get(currWord);
            if (freq == null)
                return false;
            currStringToFreq.put(currWord,
                    currStringToFreq.getOrDefault(currWord, 0) + 1);
            if (currStringToFreq.get(currWord) > freq)
                return false;
        }
        return true;
    }
}
