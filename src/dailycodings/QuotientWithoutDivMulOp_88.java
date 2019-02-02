package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuotientWithoutDivMulOp_88 {
    public static void main(String[] args) {

        try {
            quotient_op(15, 3);
        } catch (Exception e) {

        }


    }

    /*
    QuotientWithoutDivMulOp_88 dc;
    @BeforeEach
    public void init(){
        dc=new QuotientWithoutDivMulOp_88();
    }
    @Test
    public void testFirst(){
        Assertions.assertEquals(2,quotient(7,3));
    }
*/
    public int quotient(int dividend, int divisor) {
        // Calculate sign of divisor i.e.,
        // sign will be negative only iff
        // either one of them is negative
        // otherwise it will be positive
        int sign = ((dividend < 0) ^
                (divisor < 0)) ? -1 : 1;

        // Update both divisor and
        // dividend positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Initialize the quotient
        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }

        return sign * quotient;
    }

    public static long quotient_op(long dividend, long divisor) throws Exception {
        // Calculate sign of divisor
// i.e., sign will be negative
// only iff either one of them
// is negative otherwise it
// will be positive
        long sign = ((dividend < 0) ^
                (divisor < 0)) ? -1 : 1;

// remove sign of operands
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        // Calculate sign of divisor i.e.,
        if (divisor == 0L)
            throw new Exception("zero value");
        // Initialize the quotient
        long quotient = 0, temp = 0;

        // test down from the highest
        // bit and accumulate the
        // tentative value for
        // valid bit
        // 1<<31 behaves incorrectly and gives Integer
        // Min Value which should not be the case, instead
        // 1L<<31 works correctly.
        for (int i = 31; i >= 0; --i) {

            if (temp + (divisor << i) <= dividend) {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }
        System.out.println(quotient);
        return (sign * quotient);


    }

}
