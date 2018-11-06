package coderbyte;

public class CombinationsZeroOneWildCard {
    public static void main(String[] args) {
        char[] input = new char[]{'1', '?', '1', '1', '?'};

        printOutput(input, "", 0, input.length);
    }

    private static void printOutput(char[] input, String c, int pos, int t) {
        if (c.length() == t)
            System.out.println(String.valueOf(c));
        if (pos < t && input[pos] == '?') {
            printOutput(input, c.concat("0"), pos + 1, t);
            printOutput(input, c.concat("1"), pos + 1, t);
        }else if(pos<t){
            printOutput(input,c.concat(String.valueOf(input[pos])),pos+1,t);
        }
    }
}
