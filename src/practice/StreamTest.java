package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public int[] input;
    public List<Integer> list;

    @BeforeEach
    public void init() {
        input = new int[]{5, 8, 3, 4};
        list=new ArrayList<>();
        list.add(100);
        list.add(53);
        list.add(20);
        list.add(79);
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
    @Test
    public void toArrayTest(){
        Integer[] res=list.stream().toArray(Integer[]::new);
        Arrays.stream(res).forEach(op->System.out.println(op));
    }

    @Test
    public void charArrayTest(){
        String in="Bangladesh";
        char[] list=in.toCharArray();
        in.chars().forEach(i->{
            System.out.println((char) i);
        });


    }


}
