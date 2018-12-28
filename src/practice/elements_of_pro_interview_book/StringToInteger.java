package practice.elements_of_pro_interview_book;

public class StringToInteger {
    public static void main(String[] args) {

        String in = "123";
        System.out.println(toInt(in));
    }

    private static int toInt(String in) {
        return (in.charAt(0) == '-' ? -1 : 1) *
                in.substring(in.charAt(0) == '-' ? 1 : 0)
                        .chars()
                        .reduce(0, (sum, c) -> sum * 10 + c - '0');

    }
}
