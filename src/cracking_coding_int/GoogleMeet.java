package cracking_coding_int;

public class GoogleMeet {
    public static void main(String[] args) {
        int[] input=new int[]{2,2,-1};

        boolean result= isCycle(input);
        System.out.println(result);
    }


    private static boolean isCycle(int[] input) {
        int start=0;
        int len=input.length;
        boolean[] visited=new boolean[input.length];
        while (start<len){
            visited[start]=true;
            int nextPosition=input[start];
            if(nextPosition<0){
                nextPosition=start+nextPosition;
            }
            if(!visited[nextPosition]){
                start=nextPosition;
            }else{
                return true;
            }

        }
        return false;
    }
}
