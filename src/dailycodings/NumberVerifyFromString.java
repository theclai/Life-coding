package dailycodings;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

public class NumberVerifyFromString {
    private class VNode {
        char c;
        HashMap<Character, VNode> map;

        public VNode(char c) {
            this.c = c;
            this.map = new HashMap<>();
        }
    }

    VNode head;

    @BeforeEach
    public void init() {
        head = new VNode('-');
        prebuildPattern(head);
    }

    private void prebuildPattern(VNode head) {
        // second layer
        VNode hd=new VNode('*');
        head.map.put('*',hd);
        VNode hdo=new VNode('.');
        head.map.put('.',hdo);

        //third layer
        VNode hde=new VNode('e');
        VNode hddo=new VNode('.');
        VNode hdod=new VNode('*');
        hd.map.put('e',hde);
        hd.map.put('.',hddo);
        hdo.map.put('*',hdod);

        // fourth layer
        VNode hddoe=new VNode('e');
        VNode hddod=new VNode('*');
        VNode hdode=new VNode('e');
        hddo.map.put('e',hddoe);
        hddo.map.put('*',hddod);
        hddo.map.put('e',hdode);

        //Fifth layer
        VNode hddoed=new VNode('*');
        VNode hdoded=new VNode('*');

        hddoe.map.put('*',hddoed);
        hdoded.map.put('*',hdoded);
    }
}
