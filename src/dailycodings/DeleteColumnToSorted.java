package dailycodings;

import java.util.Arrays;

public class DeleteColumnToSorted {
    public static void main(String[] args) {
        minDeletionSize(new String[]{"dog","cat","mew"});
    }
    public static int minDeletionSize(String[] A) {
        int row=A.length;
        int col=A[0].length();
        int[][] matrix=new int[row][col];

        for (int i = 0; i <row ; i++) {
            String str=A[i];
            for (int j = 0; j < col; j++) {
                matrix[i][j]=(int)str.charAt(j)-'a';
            }
        }

        System.out.println(matrix);

        boolean[] process=new boolean[col];
        Arrays.fill(process,false);

        for (int i = 0; i <col ; i++) {
            if(!process[i]){
                for (int j = 1; j <row ; j++) {
                    if(matrix[j-1][i]>matrix[j][i])
                        process[i]=true;
                }
            }
        }

        System.out.println(process);
        int count=0;
        for (int i = 0; i <col ; i++) {
            if(process[i])
                count++;
        }
        return count;
    }
}
