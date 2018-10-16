package ds_algo_course.algorithms_on_graphs.week3;

public class MinStopCarFueling {
    public static void main(String[] args) {
        int[] distance = new int[]{0, 200, 375, 550, 750, 950};
        int capacity = 400;
        int target = 950;
        StringBuilder sb=new StringBuilder();
        System.out.println(findMinStop(distance, capacity, 0, target));
    }

    private static int findMinStop(int[] distance,
                                   int capacity,
                                   int total,
                                   int target) {
        int curdistance = 0;
        int curPosition = 0;
        while (curdistance < target) {
            // fuel the tank
            curdistance = curdistance + capacity;
            while (curPosition<distance.length && distance[curPosition] <= curdistance) {
                curPosition++;
            }

            // stop to the previous stop
            curPosition = curPosition - 1;
            if (curPosition < distance.length) {
                curdistance = distance[curPosition];
                if(curdistance<target)
                    total++;
            }


        }
        return total;
    }
}
