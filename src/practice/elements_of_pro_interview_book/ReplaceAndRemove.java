package practice.elements_of_pro_interview_book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * a will be replaced by dd
 * and b will be removed
 * */
public class ReplaceAndRemove {
    ReplaceAndRemove rr;
    @BeforeEach
    public void init(){
        rr=new ReplaceAndRemove();
    }
    @Test
    public void firstTest(){
        char[] in=new char[]{'a','c','d','b','b','c','a'};
        Assertions.assertEquals("ddcdcdd",rr.removeReplace(in));
    }

    public String removeReplace(char[] in){
        if(in!=null && in.length==0 )
            return "";
        int aCounter=0;
        int j=0;
        for(int i=0;i<in.length;i++){
            if(in[i]!='b')
                in[j++]=in[i];
            if(in[i]=='a')
                aCounter++;
        }

        int len=j+aCounter;

        for(int i=len-1;i>=0;i--){
            if(in[j-1]=='a') {
                in[i] = 'd';
                in[i-1]='d';
                j--;i--;
            }else{
                in[i]=in[j-1];
                j--;

            }
        }
        System.out.println(String.valueOf(in));
        return String.valueOf(in);
    }
}
