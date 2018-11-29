package dailycodings;

/**
 * Implement regular expression matching with the following special characters:
 * <p>
 * . (period) which matches any single character
 * * (asterisk) which matches zero or more of the preceding element
 * That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.
 * <p>
 * For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.
 * <p>
 * Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String str = "ray";
        String reg = "ra.";
        System.out.println(match(str, reg));
    }

    public static boolean match(String str, String reg) {
        return matchHelper(str, reg);
    }

    private static boolean matchHelper(String str, String reg) {
        if (reg.length() == 0)
            return str.equalsIgnoreCase("");

        if (str.charAt(0) == '.')
            return match(str.substring(1), reg.substring(1));

        if (str.charAt(0) == '*') {
            int i = 0;
            while (mathcesFirstChar(str.substring(i), reg)) {
                if (mathcesFirstChar(str.substring(i + 1), reg.substring(1)))
                    return true;
                i += 1;
            }
        }
        return false;
    }

    private static boolean mathcesFirstChar(String substring, String reg) {
        return (substring.charAt(0) == reg.charAt(0)) || (substring.charAt(0) == '.' && substring.length() > 1);
    }

}
