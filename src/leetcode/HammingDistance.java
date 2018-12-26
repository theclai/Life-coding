package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HammingDistance {
    HammingDistance hd;
    @BeforeEach
    public void init(){
        hd=new HammingDistance();
    }
    @Test
    public void firstTest(){
        int result= hd.findDistance(1,4);
        Assertions.assertEquals(2,result);
    }

    private int findDistance(int n1, int n2) {
        int op=n1^n2;
        int setBits=0;
        while(op>0){
            setBits+=op &1;
            op=op>>1;
        }
        return setBits;
    }

}
