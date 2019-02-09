package dailycodings;

public class Dailycoding_96 {
    public static void main(String[] args) {
        char[] in=new char[]{'1','2','3'};
        perm(in,0,in.length);
    }

    private static void perm(char[] arr, int start, int end) {
        if(start==end)
            System.out.println(String.valueOf(arr));
        for (int i = start; i <end ; i++) {
            swap(arr,start,i);
            perm(arr,start+1,end);
            swap(arr,i,start);
        }
    }

    private static void swap(char[] arr,int start, int end) {
        char temp=arr[end];
        arr[end]=arr[start];
        arr[start]=temp;
    }
}
