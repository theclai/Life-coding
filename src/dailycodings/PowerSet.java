package dailycodings;

public class PowerSet {
    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        printPowerSet(set, 3);
    }

    private static void printPowerSet(char[] set, int n) {
        long powerSet = (long) Math.pow(2, n);
        System.out.println("Target: " + powerSet);

        for (int counter = 0; counter < powerSet; counter++) {
            for (int i = 0; i < n; i++) {
                if((counter & 1<<i)>0){
                    System.out.print(set[i]);
                }
            }
            System.out.println();
        }
    }
}
