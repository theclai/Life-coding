package interviewbit;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String in1="Hello World     ";
        String in2="d";
        System.out.println("First Output: "+lengthOfLastWord(in1));
        System.out.println("Second Output: "+lengthOfLastWord(in2));

    }

    public static int lengthOfLastWord(final String A) {
        String cleanString=A.trim();
        int len=cleanString.length();
        int start=len-1;
        int counter=0;

        while(start>=0 && cleanString.charAt(start)!=' '){
            counter++;
            start--;
        }
        return counter;
    }
}
