package practice.optionals;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class OrElseTest {
    public static void main(String[] args) {
      test();
    }

    public static void test(){
         /* String result = Stream.of("outlet", "puddle", "eraser")
                .filter(s -> Character.isDigit(s.charAt(0)))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("I am done");*/


        String result2 = Stream.of("outlet", "puddle", "eraser","1FaroqueKhan")
                .filter(s -> Character.isDigit(s.charAt(0)))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(result2);
        System.out.println("I am done");
    }
}
