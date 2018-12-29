package practice.elements_of_pro_interview_book;

import java.util.HashSet;
import java.util.Set;

public class CanFormPalindrom {
    public static void main(String[] args) {
        System.out.println(canFormPalindrome("gegem"));
    }

    private static boolean canFormPalindrome(String s) {
        Set<Integer> set = new HashSet<>();
        s.chars().forEach(c -> {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        });
        return set.size() <= 1;
    }
}
