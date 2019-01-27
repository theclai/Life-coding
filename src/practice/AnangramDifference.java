package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;
import static java.util.function.Function.*;

public class AnangramDifference {
    AnangramDifference ad;

    public static void main(String[] args) {
        List<Integer> result= getMinimumDifference(Arrays.asList("abc"), Arrays.asList("def"));
        System.out.println(result);
    }


    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        if (a == null || b == null) return null;
        if (a.size() != b.size()) return null;
        if (a.size() == 0 || b.size() == 0) return null;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(remAnagram(a.get(i),b.get(i)));
        }return result;
    }

    static int remAnagram(String str1, String str2) {
        int count1[] = new int[26];
        int count2[] = new int[26];

        for (int i = 0; i < str1.length(); i++)
            count1[str1.charAt(i) - 'a']++;

        for (int i = 0; i < str2.length(); i++)
            count2[str2.charAt(i) - 'a']++;
        int result = 0;
        for (int i = 0; i < 26; i++)
            result += (count1[i] - count2[i]);
        return result;
    }

}



