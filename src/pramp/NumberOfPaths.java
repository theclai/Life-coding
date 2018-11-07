package pramp;

public class NumberOfPaths {
        /**
         we can go only up and right based on boundy condition
         total of ways to go dest

         NO Diagonal

         recursive manner
         2^M+N

         O(MN/2) O(N^2/2)

         0,1 -> 2 ways to go, and for both I need to call the recurs
         */
        static int defaultVal=0;
        static int numOfPathsToDest(int n) {
            if(n==0)
                return defaultVal;
            // your code goes here
            int[][] cache= new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0; j<n;j++){
                    if(i==0 && j==0){
                        cache[i][j]=1;
                    }else if(i>=j){
                        if(i==0 && j!=0){
                            cache[i][j]=cache[i][j-1];
                        }else if(i!=0 && j==0){
                            cache[i][j]=cache[i-1][j];
                        }else{
                            cache[i][j]=cache[i-1][j]+cache[i][j-1];

                        }
                    }
                }
            }

            return cache[n-1][n-1];
        }

        public static void main(String[] args) {

            System.out.println(numOfPathsToDest(4));

        }
}
