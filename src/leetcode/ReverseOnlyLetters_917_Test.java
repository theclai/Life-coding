package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseOnlyLetters_917_Test {
    ReverseOnlyLetters_917 revLetters;

    @BeforeEach
    public void init() {
        revLetters = new ReverseOnlyLetters_917();
    }

    @Test
    public void reverseOnlyLettersTestFirst() {
        String output = revLetters.reverseOnlyLetters("ab-cd");
        Assertions.assertEquals("dc-ba", output);
    }

    @Test
    public void reverseOnlyLettersTestSecond() {
        Assertions.assertEquals(revLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"), "Qedo1ct-eeLg=ntse-T!");
    }

    @Test
    public void reverseOnlyLettersTestThird() {
        Assertions.assertEquals(revLetters.reverseOnlyLetters("a-bC-dEf-ghIj"),
                "j-Ih-gfE-dCba");
    }
}
