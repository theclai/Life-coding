package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuotientWithoutDivMulOp_88 {
    QuotientWithoutDivMulOp_88 dc;
    @BeforeEach
    public void init(){
        dc=new QuotientWithoutDivMulOp_88();
    }
    @Test
    public void testFirst(){
        Assertions.assertEquals(1,quotient(7,3));
    }

    public int quotient(int a,int b){
        int large=a;
        while (large>b){
            large=large-b;
        }
        return large;
    }

}
