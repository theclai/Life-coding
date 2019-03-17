package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class NumberVerifyFromString {
    NumberVerifyFromString numberVerifyFromString;

    private class VNode {
        char val;
        HashMap<Character, VNode> map;

        public VNode(char c) {
            this.val = c;
            this.map = new HashMap<>();
        }
    }

    VNode head;

    @BeforeEach
    public void init() {
        numberVerifyFromString = new NumberVerifyFromString();
        head = new VNode('-');
        prebuildPattern(head);
    }

    @Test
    public void first_verify() {
        boolean result= numberVerifyFromString.verify("10");
        Assertions.assertEquals(true,result);

    }

    public boolean verify(String str) {
        char[] arr = str.toCharArray();
        if (arr[0] == '-') {
            return helper(head, arr, 0);
        } else if (Character.isDigit(arr[0])) {
            return helper(head.map.get('*'), arr, 1);
        } else {
            return false;
        }

    }

    private boolean helper(VNode parent, char[] arr, int start) {
        if (start == arr.length) return true;
        if (arr[start] == parent.val) {
            helper(parent, arr, start + 1);
        } else {
            if (parent.map.containsKey(arr[start]))
                helper(parent.map.get(arr[start]), arr, start + 1);
            else
                return false;
        }
        return false;

    }

    private void prebuildPattern(VNode head) {
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
        VNode hddoe = new VNode('e');
        VNode hddod = new VNode('*');
        VNode hdode = new VNode('e');
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
