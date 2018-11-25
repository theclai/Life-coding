package leetcode;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] in=new int[][]{{1,0}};
        System.out.printf(String.valueOf(canFinish(2,in)));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;

        if (prerequisites.length == 0)
            return true;
        HashMap<Integer, Set<Integer>> map = new HashMap();
        // create adjacency list/set
        for (int i = 0; i < numCourses; i++)
            map.put(i, new HashSet<Integer>());

        int remaining=numCourses;
        // populate the set
        for (int i = 0; i < prerequisites.length; i++) {
            int[] temp = prerequisites[i];
            map.get(temp[1]).add(temp[0]);
        }
        Queue<Integer> queue = new LinkedList();
        // find all the bottom classes without dependency and add to queue
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0){
                queue.offer(entry.getKey());
                remaining--;
            }

        }


        while(!queue.isEmpty()){
            int key=queue.poll();
            // find key in the child list  and remove it
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if (entry.getValue().contains(key)) {
                    entry.getValue().remove((Integer) key);
                    if(entry.getValue().size()==0){
                        remaining--;
                        queue.offer(entry.getKey());
                    }
                }

            }
        }
        return remaining == 0;
    }
}
