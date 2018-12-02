package leetcode;

public class MaskingPI {
    public static void main(String[] args) {
        MaskingPI mpi = new MaskingPI();
        String in1 = "LeetCode@LeetCode.com";
        String in2="AB@qq.com";
        String in3="1(234)567-890";
        String in4="86-(10)12345678";
        String in5="+5(4266)719-677-";
        String in6="JackAndJill@Gmail.Com";
        /*
        System.out.println(mpi.maskPII(in1));
        System.out.println(mpi.maskPII(in2));
        System.out.println(mpi.maskPII(in3));
        System.out.println(mpi.maskPII(in4));
        System.out.println(mpi.maskPII(in5));
        */
        System.out.println(mpi.maskPII(in6));

    }

    public String maskPII(String S) {
        String s= S.toLowerCase();
        String replaced= s.replaceAll("[^0-9a-zA-Z@.]","");
        if(Character.isDigit(replaced.charAt(replaced.length()-1)))
            return processNumber(replaced);
        else
            return processEmail(replaced);
    }

    private String processNumber(String fInput) {
        //String fInput= s.replaceAll("[^0-9]","");
        String extra="";
        StringBuilder sb=new StringBuilder();
        if(fInput.length()<10)
            return extra;
        if(fInput.length()>10){
            if(fInput.length()==12){
                extra="+**-";
            }else if(fInput.length()==13){
                extra="+***-";
            }else {
                extra="+*-";
            }

        }
        sb.append(extra);
        sb.append("***-***-");
        sb.append(fInput.substring(fInput.length()-4));


        //System.out.println(fInput);
        return sb.toString();
    }

    private String processEmail(String str) {
        //String str = S.toLowerCase();
        String[] split= str.split("@");
        StringBuilder sb=new StringBuilder();

        sb.append(split[0].charAt(0));
        sb.append("*****");
        sb.append(split[0].charAt(split[0].length()-1));
        sb.append("@");
        sb.append(split[1]);
        return sb.toString();
    }
}
