package leetcode;

public class ComplexNumberMul_537 {
    public static void main(String[] args) {
        ComplexNumberMul_537 cnm=new ComplexNumberMul_537();
        cnm.complexNumberMultiply("1+1i","1+1i");
        cnm.complexNumberMultiply("1+-1i","1+-1i");
    }
    public String complexNumberMultiply(String a, String b) {
        String[] str1=a.split("\\+");
        System.out.println(str1.length);

        int m=Integer.parseInt(str1[0]);
        int n=Integer.parseInt(str1[1].substring(0,str1[1].length()-1));


        String[] str2=b.split("\\+");


        int p=Integer.parseInt(str1[0]);
        int q=Integer.parseInt(str1[1].substring(0,str1[1].length()-1));

        //m+n   p+q
        // pm+(pn+mq)+(-1qn)

        int real= (p*m)+(-1*(q*n));
        int complex= ((p*n)+(m*q));

        StringBuilder sb=new StringBuilder();
        sb.append(real);
        sb.append("+");
        sb.append(complex);
        sb.append("i");
        System.out.println(sb.toString());

        return sb.toString();

    }

    public String advanceMul(String a, String b){
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";

    }
}
