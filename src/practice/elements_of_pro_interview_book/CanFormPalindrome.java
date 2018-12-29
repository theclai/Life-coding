package practice.elements_of_pro_interview_book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class CanFormPalindrome {
    CanFormPalindrome cp;

    @BeforeEach
    public void init() {
        cp = new CanFormPalindrome();
    }

    @Test
    public void test(){
        Assertions.assertEquals(cp.canFormPalindrome("edified"),true);
        Assertions.assertEquals(cp.canFormPalindrome("geek"),false);
    }
    public boolean canFormPalindrome(String s) {
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
