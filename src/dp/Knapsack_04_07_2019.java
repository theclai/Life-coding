package dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Knapsack_04_07_2019 {
    Knapsack_04_07_2019 knapsack;
    @BeforeEach
    public void init(){
        knapsack=new Knapsack_04_07_2019();
    }
    @Test
    public void maxValueWhenKnapsackSizeTen(){
        int size=10;
        int[] w = new int[]{5, 4, 6, 3};
        int[] v = new int[]{10, 40, 30, 50};
        int max=findMaxValue(size,w,v);
        System.out.println(max);
        Assertions.assertEquals(max,90);
    }

    private int findMaxValue(int size, int[] weights, int[] values) {
        int[][] cache=new int[weights.length+1][size+1];

        for (int i = 1; i <=weights.length ; i++) {
            int weight=weights[i-1];
            int value=values[i-1];
            for (int j = weight; j <=size ; j++) {
                if(weight<=size){
                    cache[i][j]=Math.max(cache[i-1][j],
                            value+cache[i-1][j-weight]);
                }else {
                    cache[i][j]=cache[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(cache));
        return cache[values.length][size];
    }
}
