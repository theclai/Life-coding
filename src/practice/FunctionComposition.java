package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.function.Function;

public class FunctionComposition {
    Function<String, String> demoFunc;

    @BeforeEach
    public void init() {
        demoFunc = str -> {
            String extra = "Hello ";
            return extra + str;
        };
    }

    @Test
    public void test() {
        String[] in = new String[]{"Omar", "Asma", "Eshika"};
        Arrays.stream(in).map(demoFunc).forEach(output -> System.out.println(output));
    }
}
