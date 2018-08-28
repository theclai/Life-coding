package leetcode;

public class SurfaceArea3D {

    public static void main(String[] args) {
        //int[][] data = {{1,1,1},{1,0,1},{1,1,1}};

        int A[][] = {{ 1, 3, 4 },
                { 2, 2, 3 },
                { 1, 2, 4 } };
        int res = surfaceArea(A);
        System.out.println(res);

    }

    public static int contribution_height(int current, int previous) {
        return Math.abs(current - previous);
    }

    public static int surfaceArea(int[][] A) {
        int M =A.length;
        int N=A[0].length;
        int ans = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                int up = 0;

                int left = 0;

                if (i > 0)
                    up = A[i - 1][j];

                if (j > 0)
                    left = A[i][j - 1];

                ans += contribution_height(A[i][j], up)
                        + contribution_height(A[i][j], left);

                if (i == N - 1)
                    ans += A[i][j];
                if (j == M - 1)
                    ans += A[i][j];
            }
        }
        ans += (N * M)*2 ;
        return ans;

    }

}
