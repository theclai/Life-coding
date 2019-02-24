package contest.kickstart_2019;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int test = 0;
        while (test < num) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int guess = getRandomNumberInRange(a, b);
        }


    }

    public static int getRandomNumberInRange(int a, int b) {
        return ThreadLocalRandom.current().nextInt(a, b);
    }
}
