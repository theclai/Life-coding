package cracking_coding_int.chapter_one;

public class StringRotation {
    public static void main(String[] args) {
        boolean isRotation = isRotation("waterbottle", "erbottlewat");
        System.out.println(isRotation);
    }

    private static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s=s1+s2;
            return isSubstring(s,s2);
        }
        return false;
    }

    private static boolean isSubstring(String s, String s2) {
        return s.contains(s2);
    }
}
