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
        if (typed.length() < name.length())
            return false;

        if (name.equalsIgnoreCase(typed))
            return true;

        char[] n = name.toCharArray();
        char[] t = typed.toCharArray();
        int i = 0;
        int j = i;

        char prev='*';
        boolean result=true;
        while (i < n.length) {
            char c = n[i];
            System.out.println(c);

            /*if(prev!='*' && c==prev){
                j--;
            }*/
            prev=c;
            if(j>=t.length ||c!=t[j]){
                result= false;
                break;
            }

            int counter=0;
            while (j < t.length && counter<2 && c == t[j]) {
                j++;
                counter++;
            }
            i++;
        }
        return result;

    }
}
