package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecodedString {
    DecodedString decodedString;

    @BeforeEach
    public void init() {
        decodedString = new DecodedString();
    }

    @Test
    public void decodedString_Test_Positive() {
       String input="leet2code3";
        System.out.println(decodedString.decodeAtIndex(input,10));


        String input1="ha22";
        System.out.println(decodedString.decodeAtIndex(input1,5));
        String input2="a2345678999999999999999";
        System.out.println(decodedString.decodeAtIndex(input2,1));

        String input3="a2b3c4d5e6f7g8h9";

        System.out.println(decodedString.decodeAtIndex(input3,10));

        String input4="y959q969u3hb22odq595";
        System.out.println(decodedString.decodeAtIndex(input4,222280369));

    }

    public String decodeAtIndex(String S, int K) {
        return String.valueOf(decodeHelper(S, new StringBuilder(""), 0,K));
    }
    private char decodeHelper(String input, StringBuilder sb, int pos,int target) {
        if(sb.length()>=target){
            return sb.charAt(target-1);
        }
        System.out.println("Position: "+pos+sb.toString());
        if (pos == input.length() )
            return sb.charAt(target);
        if (!Character.isDigit(input.charAt(pos))) {
            sb.append(input.charAt(pos));
            return decodeHelper(input, sb, pos + 1,target);
        } else {
            int num = Character.getNumericValue(input.charAt(pos));
            String str=sb.toString();
            for (int i = 0; i < num - 1; i++) {
                if(sb.length()+str.length()>=target){
                    sb.append(str, 0, target-sb.length());
                    break;
                }
                sb.append(str);
            }
            return decodeHelper(input, sb, pos + 1,target);
        }
    }
}
