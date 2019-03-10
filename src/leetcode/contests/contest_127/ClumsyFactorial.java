package leetcode.contests.contest_127;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ClumsyFactorial {
    ClumsyFactorial clumsyFactorial;

    @BeforeEach
    public void init() {
        clumsyFactorial = new ClumsyFactorial();
    }

    @Test
    public void first_clumsy_positive() {
        int actual = clumsyFactorial.clumsy(10);
        Assertions.assertEquals(12, actual);
    }
    @Test
    public void second_clumsy_positive() {
        int actual = clumsyFactorial.clumsy(4);
        Assertions.assertEquals(7, actual);
    }
    public int clumsy(int n) {
        LinkedList<String> list = new LinkedList<>();
        Map<Character, Character> sign = new HashMap<>();
        sign.put('*', '/');
        sign.put('/', '+');
        sign.put('+', '-');
        sign.put('-', '*');

        /*
        * Create the equation
        **/
        char start = '*';
        while (n >= 1) {
            list.add(String.valueOf(n));
            list.add(String.valueOf(start));
            start = sign.get(start);
            n--;
        }
        list.removeLast();//removing the last sign

        /**
         * Do all the multiplication first
         * */
        LinkedList<String> mul = new LinkedList<>();
        int x = 0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();

            if (next.equalsIgnoreCase(String.valueOf('*'))) {
                x = Integer.parseInt(mul.getLast());
                mul.removeLast();
            } else {
                if (x > 0) {
                    int res = x * Integer.parseInt(next);
                    x = 0;
                    mul.add(String.valueOf(res));
                } else {
                    mul.add(next);
                }
            }
        }
        list.clear();// create the equation to save memory

        /**
         * Do the division
         * */
        LinkedList<String> div = new LinkedList<>();
        Iterator<String> divIterator = mul.iterator();
        while (divIterator.hasNext()) {
            String next = divIterator.next();

            if (next.equalsIgnoreCase(String.valueOf('/'))) {
                x = Integer.parseInt(div.getLast());
                div.removeLast();
            } else {
                if (x > 0) {
                    int res = x / Integer.parseInt(next);
                    x = 0;
                    div.add(String.valueOf(res));
                } else {
                    div.add(next);
                }

            }

        }
        mul.clear();

        /**
         * do the addition and substraction
         * */
        String posSign = "+";
        int sum = 0;
        int neg = 0;

        Iterator<String> divIt = div.iterator();
        while (divIt.hasNext()) {
            String next = divIt.next();
            if (next.equalsIgnoreCase(String.valueOf('+')) || next.equalsIgnoreCase(String.valueOf('-'))) {
                posSign = next;
            } else {
                if (posSign.equalsIgnoreCase("+")) {
                    sum += Integer.parseInt(next);
                } else {
                    neg += Integer.parseInt(next);
                }
            }
        }
        return sum - neg;
    }
}
