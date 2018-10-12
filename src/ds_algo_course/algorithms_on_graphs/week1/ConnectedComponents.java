package ds_algo_course.algorithms_on_graphs.week1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        //System.out.println(adj.length);

        boolean[] visited = new boolean[adj.length + 1];
        for (int i = 1; i < adj.length; i++) {
            result+=dfs(i, adj, visited);
        }
        return result;
    }

    private static int dfs(int start,
                            ArrayList<Integer>[] adj,
                            boolean[] visited) {
        Stack<Integer> stack = new Stack();
        if (!visited[start]){
            stack.push(start);
            while (!stack.isEmpty()) {
                int data= stack.pop();
                visited[data] = true;
                for (Integer d:adj[data]) {
                    if(!visited[d])
                        stack.push(d);
                }
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

