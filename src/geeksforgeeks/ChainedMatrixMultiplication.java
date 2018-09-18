package geeksforgeeks;

public class ChainedMatrixMultiplication {
    static String dump="";
    public static void main(String[] args) {
        String in="abc";
        compute(in,0);

    }

    private static void compute(String in,int pos) {
        dump=in;
        System.out.println(dump);
        if(pos<in.length()){
            compute(in.substring(pos+1,in.length()),pos+1);
        }

    }
}
