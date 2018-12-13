package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ISSubsequence_392 {
    ISSubsequence_392 is;
    public boolean isSubsequence(String s, String t) {
        char[] string=s.toCharArray();
        char[] text=t.toCharArray();
        int i=0,j=0;
        while (i<string.length && j<text.length){
            if(string[i]==text[j])
                i++;
            j++;
        }
        if(i>=s.length())
            return true;
        return false;
    }

    @BeforeEach
    public void init(){
        is=new ISSubsequence_392();
    }
    @Test
    public void testFirst(){
        Assertions.assertEquals(true,is.isSubsequence("abc","abcde"));
    }
    @Test
    public void testSecond(){
       Assertions.assertEquals(false,is.isSubsequence("axc","ahbgdc"));
    }

    @Test
    public void testThird(){
        Assertions.assertEquals(true,is.isSubsequence("abc","ahbgdc"));
    }
}
