package practice.elements_of_pro_interview_book;

import java.util.*;

public class SmallestSequentiallySubsetCoveringSubset {
    private static class SubArray {
        public Integer start;
        public Integer end;

        public SubArray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<String> par= Arrays.asList("A","B","C","A","B","A");
        List<String> key=Arrays.asList("B","A");
        System.out.println(findSmallestSequentiallyCoveringSubset(par,key).start);
    }

    public static SubArray findSmallestSequentiallyCoveringSubset(List<String> paragraph,
                                                                  List<String> keywords) {
        Map<String, Integer> keyWordToIdx = new HashMap<>();
        List<Integer> latestOccurrence = new ArrayList<>(keywords.size());
        List<Integer> shortestSubarrayLength = new ArrayList<>(keywords.size());

        for (int i = 0; i < keywords.size(); i++) {
            keyWordToIdx.put(keywords.get(i), i);
            latestOccurrence.add(-1);
            shortestSubarrayLength.add(Integer.MAX_VALUE);
        }
        int shortestDistance = Integer.MAX_VALUE;
        SubArray result = new SubArray(-1, -1);
        for (int i = 0; i < paragraph.size(); ++i) {
            Integer keywordIdx = keyWordToIdx.get(paragraph.get(i));
            if (keywordIdx != null) {
                if (keywordIdx == 0)
                    shortestSubarrayLength.set(0, 1);
                else if (shortestSubarrayLength.get(keywordIdx - 1) != Integer.MAX_VALUE) {
                    int distPrevious = i - latestOccurrence.get(keywordIdx - 1);
                    shortestSubarrayLength.set(keywordIdx,
                            distPrevious + shortestSubarrayLength.get(keywordIdx - 1));
                }
                latestOccurrence.set(keywordIdx, i);
                if (keywordIdx == keywords.size() - 1 &&
                        shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) < shortestDistance) {
                    shortestDistance = shortestSubarrayLength.get(shortestSubarrayLength.size() - 1);
                    result.start = i - shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) + 1;
                    result.end = i;
                }
            }
        }
        return result;
    }
}
