package leetcode;

public class DeleteColMarkSorted_955 {
    public static void main(String[] args) {
        int res= minDeletionSize(new String[]{"xc","yb","za"});
        System.out.println(res);
    }

    public static int minDeletionSize(String[] A) {
        if(A==null || A.length==1) return 0;
        int min=0;
        int var=-1;
        boolean step=true;
        for(int i=0;i<A[0].length();i++){
            var=(int)A[0].charAt(i)-'a';
            for(int j=0;j<A.length;j++){
                String str=A[j];
                if((int)str.charAt(i)-'a'>=var)
                    var=(int)str.charAt(i)-'a';
                else{
                    min++;
                    break;
                }
            }
            if(min==0) return min;
        }

        return min;
    }
}
