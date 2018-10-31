package pramp;

public class ShiftedArraySearch {
    public static void main(String[] args) {
        int[] input=new int[]{9,12,17,2,4,5};
        int num=2;
        System.out.println(shiftedArrSearch(input,num));
    }

    static int shiftedArrSearch(int[] shiftArr, int num) {
        // your code goes here
        int start=0;
        int end=shiftArr.length;
        return shiftedArraySearchHelper(shiftArr,start,end,num);
    }

    public static int shiftedArraySearchHelper(int[] in, int start, int end, int num){
        int mid=(start+end)/2;
        System.out.println("start: "+ start+ "end: "+ end);
        if(num==in[mid])
            return mid;

        if(num>in[start] && num<in[mid]){
            return shiftedArraySearchHelper(in,start,mid-1,num);
        }else{
            return shiftedArraySearchHelper(in,mid+1,end-1,num);
        }
    }



}
