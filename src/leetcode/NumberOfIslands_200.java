package leetcode;

import java.util.Arrays;

public class NumberOfIslands_200 {
    public static void main(String[] args) {
       int[][] input = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        if(input==null || input.length==0 )
            System.out.println("empty");

        boolean[][] visited = new boolean[input.length][input[0].length];
        System.out.println(findNumberOfIslands(input,0,0,0,visited));
    }

    private static int findNumberOfIslands(int[][] input,int row,int col,int island,boolean[][] visited) {

        //Arrays.stream(visited).forEach(b -> System.out.println(b));

        if(row<0 || col<0 || row>=input.length || col>=input[0].length)
            return 0;
        for (int i = row; i < input.length; i++) {
            for (int j = col; j < input[0].length; j++) {
                if(!visited[i][j] && input[i][j]==1){
                    System.out.println("i: "+ i+"j: "+j);
                    visited[i][j]=true;
                    findNumberOfIslands(input,i,j+1,island,visited);
                    findNumberOfIslands(input,i+1,j,island,visited);
                    findNumberOfIslands(input,i,j-1,island,visited);
                    findNumberOfIslands(input,i-1,j,island,visited);
                    island+=1;
                }
            }
        }
        return island;
    }
}
