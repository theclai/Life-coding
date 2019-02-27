package dailycodings;

public class ReverseStringInMemory {
    public static void main(String[] args) {
        String input = "hello world here";
        char[] rChars = reverse(input.toCharArray());
        System.out.println(String.valueOf(rChars));

        char[] res=rev(rChars);

        System.out.println(String.valueOf(res));
    }

    private static char[] rev(char[] res) {
        int start=0;
        int end=0;

        while (start<res.length){
            end=find(start,res);
            reverse(start,end,res);
            start=end+2;
        }

        return res;
    }

    private static void reverse(int f, int l, char[] arr) {
        while (f<l){
            char temp = arr[l];
            arr[l] = arr[f];
            arr[f] = temp;
            f++;
            l--;
        }
    }

    private static int find(int start,char[] res) {
        if(start<res.length){
            while (start<res.length &&res[start]!=' '){
                start++;
            }
        }
        return start-1;
    }

    private static char[] reverse(char[] arr) {
        int f = 0;
        int l = arr.length - 1;

        while (f <= l) {
            char temp = arr[l];
            arr[l] = arr[f];
            arr[f] = temp;
            f++;
            l--;
        }
        return arr;
    }
}
