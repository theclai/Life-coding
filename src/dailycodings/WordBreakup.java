package dailycodings;

public class WordBreakup {
    public static void main(String[] args) {
        String input="the quick brown fox jumps over the lazy dog";
        splitWord(input);
    }

    private static void splitWord(String input) {
        int end=0;
        int start=0;
        int lastEndWord=-1;
        while (start<=end && end<input.length()){
            if(input.length()-1==end)
                System.out.println(input.substring(start,end+1));
            if(end-start<10){
                if(input.charAt(end)==' '){
                    lastEndWord=end;
                }
            }else{
                if(input.charAt(end)==' '){
                    lastEndWord=end;
                    System.out.println(input.substring(start,end));
                    start=lastEndWord;
                }else{
                    System.out.println(input.substring(start,lastEndWord));
                    start=lastEndWord+1;
                }
            }
            end++;
        }
    }
}
