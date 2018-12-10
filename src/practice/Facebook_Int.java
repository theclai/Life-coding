package practice;

public class Facebook_Int {


    public static void main(String[] args) {
        Facebook_Int fb=new Facebook_Int();
        fb.combine(new int[]{1,2,3},3);
    }

    public void combine(int[] in, int target) {
        if (in != null && in.length != 0) {
            for (int i = 0; i < in.length; i++) {
                combineHelper(in, target, 0, new StringBuilder(), i, "");
            }
        }
    }

    /**
     * @Input in array of integer
     * @Input target target to match the output
     * @Input sum sum of the current position
     * @Input position Element from the array
     */
    public void combineHelper(int[] in, int target, int sum, StringBuilder sb, int position, String operator) {
        if (sum == target && in.length - 1 == position) {
            System.out.println(sb.toString());
        } else {
            sb.append(in[position]);
            sb.append(operator);
        }
        if (position < in.length) {
            combineHelper(in, target, sum + in[position], sb, position + 1, "+");
            combineHelper(in, target, sum - in[position], sb, position + 1, "-");
        }
    }
}
