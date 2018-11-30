package leetcode;

public class OptimalDivision {
    public static void main(String[] args) {
        OptimalDivision od=new OptimalDivision();
        System.out.println(od.optimalDivision(new int[]{2,3,4}));
    }
    public String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return nums[0] + "";
        if (nums.length == 2)
            return nums[0] + "/" + nums[1];
        StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res.append("/" + nums[i]);
        }
        res.append(")");
        return res.toString();
    }
}
