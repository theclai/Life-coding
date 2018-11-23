package leetcode;

import java.util.*;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class TaskSchedular {
    public static void main(String[] args) {
        char[] input = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;//
        System.out.println(scheduleTaskByUsingMap(input, n));

        System.out.println(scheduleTaskByUsingPQ(input, n));
    }

    private static int scheduleTaskByUsingPQ(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l : temp)
                queue.add(l);
        }
        return time;
    }

    private static int scheduleTaskByUsingMap(char[] input, int n) {
        int[] task = new int[26];
        for (char c : input)
            task[c - 'A']++;


        Arrays.sort(task);
        Arrays.stream(task).forEach(i -> System.out.println(i));

        // always pick highest instance of task. start always end

        int time = 0;
        //check is there a task.
        while (task[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (task[25] == 0)
                    break;
                if (i < 26 && task[25 - i] > 0)
                    task[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(task);
        }
        return time;
    }
}
