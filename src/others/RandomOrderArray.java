package others;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomOrderArray {
    public static void main(String[] args) {
        int[] input=new int[]{1,0,3,9,2};
        int[] result=reorderArray(input);
        Arrays.stream(result).forEach(i-> System.out.println(i));
    }

    private static int[] reorderArray(int[] input) {
        int pos=input.length-1;
        while(pos>0){
            int ran=generateRandom(0,pos);
            System.out.println("Randdom: "+ ran);
            swap(input,pos,ran);
            pos--;
        }
        return input;
    }

    private static void swap(int[] in,int pos, int ran) {
        int temp=in[ran];
        in[ran]=in[pos];
        in[pos]=temp;
    }

    private static int generateRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max+1);
    }
}
