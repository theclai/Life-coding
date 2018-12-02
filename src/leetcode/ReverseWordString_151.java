package leetcode;

public class ReverseWordString_151 {
    public static void main(String[] args) {
        String input="the sky is blue";
        String in1="   a   b ";
        ReverseWordString_151 rs=new ReverseWordString_151();
        System.out.println(rs.reverseWords(input));
        System.out.println(rs.reverseWords(in1));

    }

    public String reverseWords(String s) {
        String[] input=s.split("\\s+");
        StringBuilder builder=new StringBuilder();
        for(int i=input.length-1;i>=0;i--){
            builder.append(input[i]);
            if(i!=0)
                builder.append(" ");
        }
        return builder.toString().trim();

    }
}
