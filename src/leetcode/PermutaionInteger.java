package leetcode;

import java.util.Arrays;

public class PermutaionInteger {
    public static void main(String[] args){
        String in = "DID";
        numPermsDISequence(in);
        //validPermute(in,0,in.length()-1);
    }

    public static int numPermsDISequence(String S) {
        char[] chars=new char[S.length()+1];
        int i=0;
        while(i<=chars.length-1){
            chars[i]= (char) i;
            i++;
        }
        System.out.println(new String(chars));
        return 0;

    }
    private static void validPermute(String in, int l, int r) {
        if(l==r){
            System.out.println(in);
        }
        for(int i=l;i<=r;i++){
            in= swap(in,i,l);
            validPermute(in,l+1,r);
            in=swap(in,i,l);
        }
    }

    private static String swap(String in, int i, int j) {
        char temp;
        char[] charArray = in.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
