package leetcode.contests;

public class SortArrayByParity_922 {
    public static void main(String[] args) {
        int[] input=new int[]{888,505,627,846};
        sortArrayByParityII(input);

    }

    public static int[] sortArrayByParityII(int[] in) {
        int odd=0;
        int even=0;
        for (int i = 0; i <in.length ; i++) {
            if(i%2==0){
                even=findEven(in,i);
                swap(in,i,even);

            }else{
                odd=findOdd(in,i);
                swap(in,i,odd);
            }

        }
        return  in;
    }

    private static void swap(int[] in, int even, int i) {
        int temp=in[i];
        in[i]=in[even];
        in[even]=temp;
    }

    private static int findEven(int[] in, int even) {
        while (even<in.length){
            if(in[even]%2==0){
                return even;
            }
            even++;
        }
        return even;
    }

    private static int findOdd(int[] in, int odd) {
        while (odd<in.length){
            if(in[odd]%2!=0){
                return odd;
            }
            odd++;
        }
        return odd;
    }
}
