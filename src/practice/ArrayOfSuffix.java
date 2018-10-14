package practice;

public class ArrayOfSuffix {
    public static void main(String[] args) {
        String input="Love";
        String[] suffixes=findSuffix(input);
        for (int i=0;i<suffixes.length;i++){
            System.out.println(suffixes[i]);
        }
    }

    private static String[] findSuffix(String input) {
        int N=input.length();
        String[] suffs= new String[N];
        for(int i=0;i<input.length();i++){
            suffs[i]=input.substring(i,N);
        }
        return suffs;
    }
}
