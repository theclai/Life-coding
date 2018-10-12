package ds_algo_course.algorithms_on_graphs.week1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        boolean[] visited=new boolean[adj.length];
        Stack<Integer> stack=new Stack<>();
        return dfs(adj,x,y,visited,stack);
        //return 0;
    }

    private static int dfs(ArrayList<Integer>[] adj,
                           int src,
                           int dst,
                           boolean[] visited,
                           Stack<Integer> stack) {
        stack.add(src);
        while (!stack.isEmpty()){
            int node=stack.peek();
            if (node==dst)
                return 1;
            visited[node]=true;
            for(int i=0;i<adj[i].size();i++){
                if(!visited[adj[node].get(i)]){
                    stack.add(adj[node].get(i));
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

