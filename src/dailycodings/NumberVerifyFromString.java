package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class NumberVerifyFromString {
    NumberVerifyFromString numberVerifyFromString;

    class VNode {
        char val;
        HashMap<Character, VNode> map;

        public VNode(char c) {
            this.val = c;
            this.map = new HashMap<>();
        }
    }

    static VNode head;

    @BeforeEach
    public void init() {
        numberVerifyFromString = new NumberVerifyFromString();
        head = new VNode('-');
        prebuildPattern();
    }

    @Test
    public void first_verify() {
        String in = modifiedString("10");
        boolean result = numberVerifyFromString.verify(in);
        Assertions.assertEquals(true, result);
    }


    @Test
    public void second_verify() {
        String in = modifiedString("-10");
        boolean result = numberVerifyFromString.verify(in);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void third_verify() {
        String in = modifiedString("a");
        boolean result = numberVerifyFromString.verify(in);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void fourth_verify_positive() {
        String in = modifiedString("1e5");
        boolean result = numberVerifyFromString.verify(in);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void fifth_verify_negative() {
        String in = modifiedString("a-2");
        boolean result = numberVerifyFromString.verify(in);
        Assertions.assertEquals(false, result);

    }

    private String modifiedString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i]))
                chars[i] = '*';
        }
        return String.valueOf(chars);
    }

    public boolean verify(String str) {
        char[] arr = str.toCharArray();
        if (arr[0] == '-') {
            return helper(head, arr, 0);
        } else if (arr[0] == '*') {
            return helper(head.map.get('*'), arr, 0);
        } else {
            return false;
        }

    }

    private boolean helper(VNode parent, char[] arr, int start) {
        if (start == arr.length) return true;
        if (arr[start] == parent.val) {
            return helper(parent, arr, start + 1);
        } else {
            if (parent.map.containsKey(arr[start]))
                return helper(parent.map.get(arr[start]), arr, start + 1);
            else
                return false;
        }
    }

    private void prebuildPattern() {
        // second layer
        VNode hd = new VNode('*');
        head.map.put('*', hd);
        VNode hdo = new VNode('.');
        head.map.put('.', hdo);

        //third layer
        VNode hde = new VNode('e');

        VNode hddo = new VNode('.');
        VNode hdod = new VNode('*');
        hd.map.put('e', hde);
        hd.map.put('.', hddo);
        hdo.map.put('*', hdod);

        // fourth layer
        VNode hded = new VNode('*');
        VNode hddoe = new VNode('e');
        VNode hddod = new VNode('*');
        VNode hdode = new VNode('e');
        hde.map.put('*', hded);
        hddo.map.put('e', hddoe);
        hddo.map.put('*', hddod);
        hddo.map.put('e', hdode);

        //Fifth layer
        VNode hddoed = new VNode('*');
        VNode hdoded = new VNode('*');

        hddoe.map.put('*', hddoed);
        hdoded.map.put('*', hdoded);
    }

}
