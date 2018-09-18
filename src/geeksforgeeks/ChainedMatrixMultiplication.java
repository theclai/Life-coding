package geeksforgeeks;

public class ChainedMatrixMultiplication {
    static String dump="";
    static String beg="";
    public static void main(String[] args) {
        String in="abc";
        compute(in,0);

    }

    private static void compute(String in,int pos) {
        dump=beg+"->"+in;
        System.out.println(dump);
        if(pos<=in.length()){
            beg=beg+in.substring(0,pos+1);
            compute(in.substring(pos+1,in.length()),pos);
        }

    }
}
