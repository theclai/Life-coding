package leetcode;

//-2,1,-3,4,-1,2,1,-5,4
public class ContigousSubArraySumKadane {
    public int sum(int[] input) {
        int max_ending = input[0];
        int max_so_far = input[0];
        for (int i = 1; i < input.length; i++) {
            //max_ending=max_ending+input[i];
            max_ending = Integer.max(max_ending, max_ending + input[i]);
            if (max_ending > max_so_far) {
                max_so_far = max_ending;
            }
        }
        System.out.println(max_so_far);
        return max_so_far;
    }

    public int subSum(int[] nums) {
        if(nums.length==0){return 0;}

        int total=nums[0], maxTotal=nums[0];

        for(int i=1; i<nums.length; i++){
            total = (total>0) ? total+nums[i] : nums[i];
            System.out.println("total sum: "+ total);
            maxTotal = (maxTotal>total) ? maxTotal : total;
        }
        System.out.println(maxTotal);
        return maxTotal;
    }
}
