package practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");

        /*
        Stack s=new Stack();
        Deque a=new ArrayDeque();

        PriorityQueue<Integer> pq=new PriorityQueue<>(5,Collections.reverseOrder());
        pq.add(5);
        pq.add(3);
        pq.add(4);
        pq.add(1);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
*/
        Map<String,String> map=new HashMap<>();
        map.computeIfAbsent("Omar",data->"Faroque");

        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getValue());
        }


    }
}
