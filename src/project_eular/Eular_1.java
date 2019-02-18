package project_eular;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Eular_1 {
    Eular_1 eular_1;

    @BeforeEach
    public void init() {
        eular_1 = new Eular_1();
    }

    @Test
    public void first_findSum_test_positive() {
        Assertions.assertEquals(2318, findSum(100));
    }

    public static int findSum(int n) {
        n--; //Since we need to compute the sum less than n.
//Check if n is more than or equal to 3 then compute sum of all divisible by
//3 and add to sum.
        long totalElements = 0;
        long sum = 0;
        if (n >= 3) {
            totalElements = n / 3;
            sum += (totalElements * (3 + totalElements * 3)) / 2;
        }

//Check if n is more than or equal to 5 then compute sum of all elements
//divisible by 5 and add to sum.
        if (n >= 5) {
            totalElements = n / 5;
            sum += (totalElements * (5 + totalElements * 5)) / 2;
        }

//Check if n is more than or equal to 15 then compute sum of all elements
//divisible by 15 and subtract from sum.
        if (n >= 15) {
            totalElements = n / 15;
            sum -= (totalElements * (15 + totalElements * 15)) / 2;
        }
        return (int) sum;
    }

}



