package leetcode;

public class CountingBits {
    public static void main(String[] args){
        int num=2;
        System.out.println(count(num));
    }

    private static int[] count(int num) {
        int[] result=new int[num+1];
        if(num==0){
            result[0]=0;
            return result;
        }
        result[0]=0;
        for(int i=1;i<=num;i++){
            result[i]= result[i & (i-1)]+1;
        }
        return result;
    }
}
