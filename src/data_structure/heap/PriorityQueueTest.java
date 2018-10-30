package data_structure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> pq=new PriorityQueue<>(Comparator.comparingInt(String::length));
        pq.add("Bangladesh");
        pq.add("omar");
        pq.add("faroque");
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}
