package leetcode.contests;

public class DisjointInterval {
    public static void main(String[] args) {
        //int[] in=new int[]{1,1,1,0,6,12};
        int[] in = new int[]{32, 57, 24, 19, 0, 24, 49, 67, 87, 87};
        System.out.println(findDisjoin(in));
    }

    private static int findDisjoin(int[] in) {
        int i = 0;
        int j = in.length - 1;
        int max=in[0];
        while (i < j) {
            if(in[i]>max){
                max=in[i];
            }
            if(max<in[j]){
                i++;
                j--;
            }

        }

        return j;
    }
}
