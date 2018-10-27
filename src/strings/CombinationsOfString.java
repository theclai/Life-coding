package strings;

public class CombinationsOfString {
    public static String inputstring;

    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        inputstring = "wxyz";
        combine(0);
    }

    private static void combine(int start) {
        //System.out.println("Start" + out.toString());
        for( int i = start; i < inputstring.length(); ++i ){
            output.append( inputstring.charAt(i) );
            System.out.println( output );
            if ( i < inputstring.length() )
                combine( i + 1);
            output.setLength( output.length() - 1 );
        }
    }
}
