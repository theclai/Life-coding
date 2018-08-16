package leetcode;

public class PrintingBinary {
    public static void main(String[] args){
        int number = 3;
        findBinary(number);
    }

    private static void findBinary(int number) {
        String prefix = "";
        findBinaryHelper(number,prefix);
    }

    private static void findBinaryHelper(int number, String prefix) {
        System.out.println("Number: "+ number+" Prefix: "+prefix);
        if(number==0){
            System.out.println(prefix);
        }else{
            findBinaryHelper(number-1,prefix+"0");
            findBinaryHelper(number-1,prefix+"1");
        }
    }
}
/***
 * callstack:
 * findBinaryHelper(3)
 *
 * */