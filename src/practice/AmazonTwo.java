package practice;

import java.util.ArrayList;
import java.util.List;

public class AmazonTwo {
    public static void main(String[] args) {
        AmazonTwo two = new AmazonTwo();

        List<Integer> a=new ArrayList<>();
        a.add(1);a.add(0);a.add(0);

        List<Integer> b=new ArrayList<>();
        b.add(1);b.add(0);b.add(0);

        List<Integer> c=new ArrayList<>();
        c.add(1);c.add(9);c.add(1);

        List<List<Integer>> input=new ArrayList<>();
        input.add(a);input.add(b);input.add(c);

        two.removeObstacle(3,3,input);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        int[] obstacle=findObstacle(numRows,numColumns,lot);
        System.out.println(obstacle[0]+" "+obstacle[1]);
        int counter=0;
        int res= findMin(obstacle[0],obstacle[1],lot,counter);
        System.out.println(res);
        return 0;
    }

    private int findMin(int row,int col, List<List<Integer>> lot, int counter) {
        if(row==0 && col==0)
            return counter;

        if(row>=0 && row<=lot.size() && col>=0 && col<lot.get(0).size() )
        {
            if(lot.get(row).get(col)==0)
                return Integer.MAX_VALUE;
            else{
                int top= findMin(row-1,col,lot,counter+1);
                int left=findMin(row,col-1,lot,counter+1);
                return Math.min(top,left);
            }
        }else {
            return counter;
        }
    }

    private int[] findObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        for(int i=0;i<numRows;i++){
            List<Integer> temp=lot.get(i);
            for (int j = 0; j <numColumns ; j++) {
                int obstacle=temp.get(j);
                if(obstacle==9)
                    return new int[]{i,j};

            }
        }
        return new int[0];
    }

}
