package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static class Edge {
        int from;
        int to;
        double weight;

        Edge(int f, int t, double w) {
            this.from = f;
            this.to = t;
            this.weight = w;
        }
    }

    public static void main(String[] args) {
        Edge[] edges = new Edge[16];

        edges[0] = new Edge(0, 7, 0.16);
        edges[1] = new Edge(2, 3, 0.17);
        edges[2] = new Edge(1, 7, 0.19);
        edges[3] = new Edge(0, 2, 0.26);

        edges[4] = new Edge(5, 7, 0.28);
        edges[5] = new Edge(1, 3, 0.29);
        edges[6] = new Edge(1, 5, 0.32);
        edges[7] = new Edge(2, 7, 0.34);

        edges[8] = new Edge(4, 5, 0.35);
        edges[9] = new Edge(1, 2, 0.36);
        edges[10] = new Edge(4, 7, 0.37);
        edges[11] = new Edge(0, 4, 0.38);

        edges[12] = new Edge(6, 2, 0.40);
        edges[13] = new Edge(3, 6, 0.52);
        edges[14] = new Edge(6, 0, 0.58);
        edges[15] = new Edge(6, 4, 0.93);

        ArrayList<ArrayList<Edge>> e = createGraph(edges);
        ArrayList<Edge> mst = findMst(e);

        System.out.println("MST: ");
        for(Edge edge:mst){
            System.out.println(edge.from+" - "+edge.to+" : "+edge.weight);
        }
    }

    private static ArrayList<Edge> findMst(ArrayList<ArrayList<Edge>> G) {
        if(G.isEmpty())throw new NullPointerException("The Graph is empty");

        ArrayList<Edge> mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((Object o1, Object o2) -> {
            Edge first = (Edge)o1;
            Edge second = (Edge)o2;

            if(first.weight<second.weight)return -1;
            else if(first.weight>second.weight)return 1;
            else return 0;
        });

        for(Edge e:G.get(0)){
            pq.add(e);
        }

        boolean[] marked = new boolean[G.size()];
        marked[0] = true;
        while(!pq.isEmpty()){
            Edge e = pq.peek();

            pq.poll();
            if(marked[e.from] && marked[e.to])continue;
            marked[e.from] = true;
            for(Edge edge:G.get(e.to)){
                if(!marked[edge.to]){
                    pq.add(edge);
                }
            }
            marked[e.to] = true;
            mst.add(e);
        }
        return mst;
    }

    private static ArrayList<ArrayList<Edge>> createGraph(Edge[] edges) {
        ArrayList<ArrayList<Edge>> G = new ArrayList<>();
        int length = edges.length*2;
        for(int i=0;i<length;++i){
            G.add(new ArrayList<>());
        }

        for(Edge e:edges){
            Edge other = new Edge(e.to, e.from, e.weight);
            G.get(e.from).add(e);
            G.get(e.to).add(other);
            System.out.println("Added edge ["+e.from+", "+e.to+" : "+e.weight+"] "+"["+e.to+", "+e.from+" : "+e.weight+"]");
        }

        return G;


    }
}
