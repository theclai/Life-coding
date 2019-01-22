package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UglyNumberII_264 {
    UglyNumberII_264 un;
    @BeforeEach
    public void init(){
        un=new UglyNumberII_264();
    }
    @Test
    public void test(){
        Assertions.assertEquals(12,un.nthUglyNumber(1352));
    }
    public int nthUglyNumber(int n) {
        Set<Integer> ugly=new HashSet<>();
        ugly.add(1);
        int val=2;
        while(ugly.size()!=n){
            if(val%2==0 && ugly.contains(val/2))
                ugly.add(val);
            else if(val%3==0 &&ugly.contains(val/3))
                ugly.add(val);
            else if(val%5==0 &&ugly.contains(val/5))
                ugly.add(val);
            val+=1;


        }
        return val-1;
    }
}
