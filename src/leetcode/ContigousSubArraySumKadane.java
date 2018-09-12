package leetcode;

//-2,1,-3,4,-1,2,1,-5,4
public class ContigousSubArraySumKadane {
    public int sum(int[] input) {
        int max_ending = 0;
        int max_so_far = 0;
        for (int i = 0; i < input.length; i++) {
            max_ending=max_ending+input[i];
            if (max_ending < 0) {
                max_ending = 0;
            }
            if (max_ending > max_so_far) {
                max_so_far = max_ending;
            }
        }
        System.out.println(max_so_far);
        return max_so_far;
    }
}
