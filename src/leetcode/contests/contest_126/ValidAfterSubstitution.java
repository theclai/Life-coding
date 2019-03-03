package leetcode.contests.contest_126;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidAfterSubstitution {
    ValidAfterSubstitution validAfterSubstitution;

    @BeforeEach
    public void init() {
        validAfterSubstitution = new ValidAfterSubstitution();
    }

    @Test
    public void test_first_validaftersubstitution_positive() {
        Assertions.assertEquals(true, validAfterSubstitution.isValid("aabcbc"));
    }

    @Test
    public void test_second_validaftersubstitution_positive() {
        Assertions.assertEquals(true, validAfterSubstitution.isValid("abcabcababcc"));
    }

    @Test
    public void test_third_validaftersubstitution_negetive() {
        Assertions.assertEquals(false, validAfterSubstitution.isValid("abccba"));
    }

    @Test
    public void test_fourth_validaftersubstitution_negetive() {
        Assertions.assertEquals(false, validAfterSubstitution.isValid("cababc"));
    }

    public boolean isValid(String S) {
        if (S.length() < 3) return false;
        String left = "";
        while (S.length() > 3) {
            int hit = S.indexOf("abc");
            /**
             * it the word is not found, then it will return -1
             * you return false
             * */

            if (hit < 0) return false;
            /**
             * If the first three letter is abc,then update S as rest of the word
             * */
            if (hit == 0) {
                S = S.substring(hit + 3);
                System.out.println(S);
            } else {
                /**
                 * what happen if you find abc in the middle of the word
                 * */
                S = S.substring(0, hit) + S.substring(hit + 3);
            }
        }
        if (left.concat(S).equalsIgnoreCase("ABC")) return true;
        return false;
    }
}
