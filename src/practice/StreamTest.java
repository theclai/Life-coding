package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StreamTest {
    public int[] input;

    @BeforeEach
    public void init() {
        input = new int[]{5, 8, 3, 4};
    }

    @Test
    public void sumTest() {
        int result = Arrays.stream(input).sum();
        Assertions.assertEquals(20, result);
    }

    @Test
    public void filterTest() {
        int result = Arrays.stream(input)
                .filter(i -> i >= 5)
                .sum();
        Assertions.assertEquals(13, result);

    }

}
