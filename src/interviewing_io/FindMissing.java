package interviewing_io;

public class FindMissing {
    public static void main(String[] args) {
        int[] a = new int[]{4, 8, 12, 9, 3};
        int[] b = new int[]{4, 8, 9, 3};

        System.out.println(findMissing(a, b));
        System.out.println(findMissingWithoutOverflow(a, b));
    }

    private static int findMissing(int[] a, int[] b) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (i == b.length - 1) {
                sum2 = sum2 + 0;
                sum1 = sum1 + a[i];
            } else {
                sum1 = sum1 + a[i];
                sum2 = sum2 + b[i];
            }
        }
        return sum1 - sum2;
    }


    private static int findMissingWithoutOverflow(int[] bigger,
                                                  int[] smaller) {
        int sum=0;
        int h1=0;
        int h2=0;
        while(h1<bigger.length && h2<smaller.length){
            sum+=bigger[h1];
            sum-=smaller[h2];
            h1++;
            h2++;
        }
        if(h1<bigger.length){
            sum+=bigger[h1];
        }
        if(h2<smaller.length)
            sum-=smaller[h2];
        return sum;
    }
}
