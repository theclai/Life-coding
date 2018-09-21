package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HappyNumber_202_Test {
    HappyNumber_202 happyNumber;

    @BeforeEach
    public void init() {
        happyNumber = new HappyNumber_202();
    }
    @Test
    public void test(){
        int n=19;
        boolean exp=happyNumber.findHappy(n);
        Assertions.assertEquals(exp,true);
    }
}
