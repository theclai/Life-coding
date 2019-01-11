package practice;

public class CompilerTest {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 100}
        };

        int[][] b = new int[][]{
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100},
                {11, 22, 33, 44, 55, 66, 77, 88, 99, 100}

        };

        long start1 = System.nanoTime();
        computeByCol(a, b);
        long end1 = System.nanoTime();
        long diff1=end1-start1;
        System.out.println(diff1);

        long start = System.nanoTime() ;
        computeByRow(a, b);
        long end = System.nanoTime();
        long diff=end-start;
        System.out.println(diff);

        if(diff1-diff>0)
            System.out.println("takes more time");

    }

    private static void computeByCol(int[][] a, int[][] b) {
        int[][] c = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                c[j][i] = a[j][i] + b[j][i];
            }

        }
    }

    private static void computeByRow(int[][] a, int[][] b) {
        int[][] c = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }

        }
    }
}
