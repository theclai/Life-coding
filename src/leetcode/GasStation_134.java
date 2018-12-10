package leetcode;

public class GasStation_134 {
    public static void main(String[] args) {
        GasStation_134 g = new GasStation_134();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(g.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int start = 0;
        int sumRemaining = 0;
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            int c = cost[i];
            int g = gas[i];
            int remaining = g - c;

            if (sumRemaining >= 0) {
                sumRemaining += remaining;
            } else {
                start = i;
                sumRemaining = remaining;
            }
            total += remaining;
        }
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public int canCompleteCircuitBetter(int[] gas, int[] cost) {

        int start = 0;
        int tank = 0;
        int total = 0;
        int deficit = 0;
        // if tank has negetive fuel i can not reach next station
        // i have to start from the next position
        // since i have started again make the tank empty.Always we start with empty tank
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                deficit = tank;
                tank = 0;

            }

        }
        return tank + deficit >= 0 ? start : -1;
    }
}
