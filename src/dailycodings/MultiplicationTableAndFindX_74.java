package dailycodings;

public class MultiplicationTableAndFindX_74 {
    public static void main(String[] args) {
        int n=6;
        int x=12;
        System.out.println(find(n,x));
    }

    private static int find(int n, int x) {
        int total=0;
        int min=n/x;
        for (int i = min-1; i <=n ; i++) {
            for (int j = min-1; j <=n ; j++) {
                if(i*j==x)
                    total+=1;
            }
        }
        return total;
    }
}
