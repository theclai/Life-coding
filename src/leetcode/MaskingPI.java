package leetcode;

public class MaskingPI {
    public static void main(String[] args) {
        MaskingPI mpi = new MaskingPI();
        String in1 = "LeetCode@LeetCode.com";
        String in2="AB@qq.com";
        System.out.println(mpi.maskPII(in1));
        System.out.println(mpi.maskPII(in2));

    }

    public String maskPII(String S) {
        if(Character.isDigit(S.charAt(S.length()-1)))
            return processNumber(S);
        else
            return processEmail(S);

    }

    private String processNumber(String s) {
        return null;
    }

    private String processEmail(String S) {
        String str = S.toLowerCase();
        String[] split= str.split("@");
        StringBuilder sb=new StringBuilder();

        sb.append(split[0].charAt(0));
        sb.append("*****");
        sb.append(split[0].charAt(split.length-1));
        sb.append("@");
        sb.append(split[1]);
        return sb.toString();
    }
}
