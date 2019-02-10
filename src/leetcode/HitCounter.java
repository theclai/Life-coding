package leetcode;

public class HitCounter {
    public static void main(String[] args) {
        HitCounter hc = new HitCounter();



        //["HitCounter","hit","hit","hit","getHits","getHits","getHits","getHits","getHits","hit","getHits"]
        //[[],          [2],   [3],  [4],    [300],   [301],    [302],    [303],[   304],[501],[600]]

        hc.hit(2);
        hc.hit(3);
        hc.hit(4);
        System.out.println(hc.getHits(300));
        System.out.println(hc.getHits(301));
        System.out.println(hc.getHits(302));
        System.out.println(hc.getHits(303));
        System.out.println(hc.getHits(304));

        //hc.hit(500);
        System.out.println(hc.getHits(600));

    }
    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}
