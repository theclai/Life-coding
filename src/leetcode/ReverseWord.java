package leetcode;

public class ReverseWord {
    public static void main(String[] args){
        String input = "I:love:you";
        String[] words = splitWord(input);
        for ( String ss : words) {
            System.out.println(ss);
        }
    }

    private static String[] splitWord(String input) {
        String[] out = input.split(":");
        return out;
    }
}
