package kickstart.year_2018;
import java.util.Scanner;

class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num=scanner.nextInt();
        for (int i = 0; i <num ; i++) {
           int input= scanner.nextInt();
           System.out.println(compute(input));
        }

    }

    private static int compute(int input) {
        if (input<10 && input%2==0){
            return 0;
        }

        else{
            return Math.min(helperIncrease(input,0),helperDecrease(input,0)) ;
        }
    }

    private static int helperIncrease(int input, int effort) {

        if(isAllDigitsAreEven(input)){
            return effort;
        }
        return helperIncrease(input+1,effort+1);
    }

    private static int helperDecrease(int input, int effort) {

        if(isAllDigitsAreEven(input)){
            return effort;
        }
        return helperDecrease(input-1,effort+1);
    }

    private static boolean isAllDigitsAreEven(int num) {
        while (num != 0) {
            int digit = num % 10;
            if(digit%2!=0)return false;
            num /= 10;
        }
        return true;
    }
}
