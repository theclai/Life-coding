package coderbyte;

public class FindSubArray {
    public static void main(String[] args) {
        int[] in=new int[]{3,2,7,1};
        int S=19;
        int pos=0;
        System.out.println(insert(in,S,pos));
    }

    private static boolean insert(int[] in, int s, int pos) {
        if(s==0)
            return true;
        if(pos>=in.length)
            return false;

        return insert(in,s-in[pos],pos+1)||
                    insert(in,s,pos+1);

    }
}
