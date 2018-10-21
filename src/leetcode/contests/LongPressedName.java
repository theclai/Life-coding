package leetcode.contests;

public class LongPressedName {
    public static void main(String[] args) {
        //String name1 = "alex";
        //String typed1 = "aaleex";

        //String name1="saeed";
        //String typed1="ssaaedd";

        String name1="leelee";
        String typed1="lleeelee";

        //String name1="laiden";
       // String typed1="laiden";

        //String name1="pyplrz";
        //String typed1="ppyypllr";
        System.out.println(isLongPressedName(name1, typed1));

    }

    public static boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }
        return true;
    }
}
