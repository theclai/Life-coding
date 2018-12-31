package leetcode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KMergeSortedList_23 {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);

        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(6);

        ListNode[] in = new ListNode[]{h1, h2, h3};
        ListNode out = mergeKLists(in);

        while (out!=null){
            System.out.println(out.val);
            out=out.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] arr) {
        if(arr==null || arr.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        ListNode HEAD=null;
        ListNode last=null;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=null)
                pq.add(arr[i]);
        }
        while (!pq.isEmpty()){
            ListNode top= pq.peek();
            pq.remove();


            if(top.next!=null){
                pq.add(top.next);
            }

            if(HEAD==null){
                HEAD=top;
                last=top;
            }else{
                last.next=top;
                last=top;
            }

        }
        return HEAD;
    }
}
