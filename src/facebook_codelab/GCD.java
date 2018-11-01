package facebook_codelab;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(1,0));
    }
    public static int gcd(int n1, int n2) {
        if(n1==0)
            return 0;
        if(n2==0)
            return n1;
        while(n1 != n2)
        {
            if(n1 > n2)
                n1 -= n2;
            else
                n2 -= n1;
        }
        return n1;
    }
}
