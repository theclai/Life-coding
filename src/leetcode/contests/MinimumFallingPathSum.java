package leetcode.contests;

public class MinimumFallingPathSum {
    static int[][] input = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    public static void main(String[] args) {
        MinimumFallingPathSum mp = new MinimumFallingPathSum();
        mp.minFallingPathSum(input);

    }

    public int minFallingPathSum(int[][] A) {
        int counter=0;
        for(int i=0;i<input[0].length;i++){
            counter= helper(A,0,i,counter);

        }
        return counter;
    }

    private int helper(int[][] a,int row, int col,int counter) {
        System.out.println(counter);
        if(row>=0 && row<a.length && col>=0 && col<a[0].length){
            int mid=helper(a,row+1,col,counter);//mid element
            int left=helper(a,row+1,col-1,counter);// left element
            int right= helper(a,row+1,col+1,counter); //right element
            return (mid+left+right);
        }
        return 1;
    }
}
