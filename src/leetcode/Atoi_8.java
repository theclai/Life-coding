package leetcode;

public class Atoi_8 {
    public static void main(String[] args) {
        Atoi_8 atoi = new Atoi_8();
        System.out.println(atoi.myAtoi("3.14159"));
        System.out.println(atoi.myAtoi("   -42"));
        System.out.println(atoi.myAtoi("4193 with words"));
        System.out.println(atoi.myAtoi("words and 987"));
        System.out.println(atoi.myAtoi("-91283472332"));


    }

    public int myAtoi(String str) {
        if (str.trim() == null || str.trim().length() == 0) return 0;

        str = str.trim();
        StringBuffer tmpStr;
        Double result;
        boolean beyond = true;

        if (str.charAt(0) == '-') beyond = false;

        if (str.charAt(0) == '-' || str.charAt(0) == '+') str = str.substring(1);

        tmpStr = meddelProcess(str);
        if (tmpStr.length() == 0) return 0;
        result = Double.parseDouble(tmpStr.toString());
        if (result > Integer.MAX_VALUE && beyond) return Integer.MAX_VALUE;
        if (result > Integer.MAX_VALUE && !beyond) return Integer.MIN_VALUE;
        return beyond ? (int) (0 + result) : (int) (0 - result);
    }

    private StringBuffer meddelProcess(String str) {
        StringBuffer tmpStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            tmpStr.append(str.charAt(i)).toString();
        }
        return tmpStr;
    }
}
