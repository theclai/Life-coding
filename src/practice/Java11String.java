package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Java11String {
    @Test
    public void stripingString() {
        String s = "      Hello World Omar       ";
        //Assertions.assertEquals("Hello World Omar", s.strip());
    }

    @Test
    public void stripLeadingString() {
        String s = "      Hello World Omar ";
        //Assertions.assertEquals("Hello World Omar ", s.stripLeading());
    }

    @Test
    public void stripTrailingString() {
        String s = "Hello World Omar ";
        //Assertions.assertEquals("Hello World Omar", s.stripTrailing());
    }

    @Test
    public void blankString() {
        String s = "   ";
       // Assertions.assertEquals(true, s.isBlank());

        Assertions.assertEquals(false, s.isEmpty());
    }

    @Test
    public void repeatString() {
        String s = " * ";
        //Assertions.assertEquals(" *  *  * ", s.repeat(3));
    }

    @Test
    public void lineStreamingString() {
        String s = "jujube\nsatsuma\nguava";
       /* s.lines()
                .forEach(System.out::println);*/
    }


}
