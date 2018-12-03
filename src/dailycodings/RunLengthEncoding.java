package dailycodings;

public class RunLengthEncoding {
    public static void main(String[] args) {
        RunLengthEncoding rle=new RunLengthEncoding();
        String input="ABBCCCD";
        String encodedString= rle.encode(input);
        System.out.println(encodedString);

        String decodedString= rle.decode(encodedString);
        System.out.println(decodedString);

    }

    public String encode(String input) {
        StringBuilder sb=new StringBuilder();
        char[] in=input.toCharArray();

        for(int i=0;i<in.length;++i){
            int count=1;
            int j=i+1;
            char c = in[i];
            while(j<in.length && c==in[j]){
                count++;
                j++;
            }
            if(count>1){
                i+=count-1;
            }
            sb.append(c);
            sb.append(count);
        }
        return sb.toString();
    }

    public String decode(String encodedString) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<encodedString.length();i=i+2){
            char c=encodedString.charAt(i);
            int count=Integer.parseInt(String.valueOf(encodedString.charAt(i+1)));
            int j=0;
            while (j<count){
                sb.append(c);
                j++;
            }
        }
        return sb.toString();
    }
}
