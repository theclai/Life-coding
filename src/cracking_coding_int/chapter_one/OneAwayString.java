package cracking_coding_int.chapter_one;

public class OneAwayString {
    public static void main(String[] args) {
        OneAwayString oneAwayString = new OneAwayString();
        System.out.println(oneAwayString.oneEditAway("pale", "ple"));
        System.out.println(oneAwayString.oneEditAway("pales", "pale"));
        System.out.println(oneAwayString.oneEditAway("pale", "bae"));

    }

    public boolean oneEditAway(String a, String b) {
        /**
         * If there length difference is more than 1 then answer is false
         * */
        if (Math.abs(a.length() - b.length()) > 1)
            return false;

        // find shorter  and longer string
        // s1 is shroter and s2 is longer

        String s1 = (a.length() < b.length()) ? a : b;
        String s2 = (a.length() > b.length()) ? a : b;

        int index1 = 0;// index1 will be used with shorter
        int index2 = 0; // index2 will be used with longer

        boolean foundDifference = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference)
                    return false; // if there was a difference found before, here is another one so return false
                foundDifference = true;
                if(s1.length()==s2.length()){
                    index1++;
                }
            }else {
                index1++;
            }
            index2++;
        }

        return true;

    }
}
