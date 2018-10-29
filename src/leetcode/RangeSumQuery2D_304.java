package leetcode;

public class RangeSumQuery2D_304 {
    static int[][] matrix = new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
    };
    RangeSumQuery2D_304(int[][] matrix) {


    }
    public static void main(String[] args) {
        RangeSumQuery2D_304 rm = new RangeSumQuery2D_304(matrix);
        System.out.println(rm.sumRegion(2,1,4,3));
        System.out.println(rm.sumRegion(1,1,2,2));
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            for (int j = col1; j <=col2 ; j++) {
                System.out.println(matrix[i][j]);
                sum+=matrix[i][j];
            }
        }
        return sum;

    }
}
