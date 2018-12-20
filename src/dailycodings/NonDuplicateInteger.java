package dailycodings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class NonDuplicateInteger {
    public int nonDuplicate(int[] input) {
        int sum = Arrays.stream(input).sum();

        for (int i = 0; i < input.length; i++) {
            if ((sum - input[i]) % 3 == 0)
                return input[i];
        }
        return -1;
    }

    NonDuplicateInteger ndi;

    @BeforeEach
    public void init() {
        ndi = new NonDuplicateInteger();
    }

    @Test
    public void test1() {
        int[] in = new int[]{19, 13, 13, 13};
        Assertions.assertEquals(19, ndi.nonDuplicate(in));
    }

    @Test
    public void test2() {
        int[] in = new int[]{6, 1, 3, 3, 3, 6, 6};
        Assertions.assertEquals(1, ndi.nonDuplicate(in));
    }
}
