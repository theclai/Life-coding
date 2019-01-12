package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * This class {@link EasyToDialValidation}, is a helper class
 * to validate the phone number is easy to dial or not
 */
public class EasyToDialValidation {
    EasyToDialValidation mEasyToDialValidation;
    /**
     * Number of characters number in phone keyboard
     */
    private static final int NUMBER_OF_CHARACTERS = 10;

    /**
     * Length of the phone number
     */
    private static final int NUMBER_LEN = 7;

    /**
     * Regex pattern
     */
    private static final String PATTERN = "\\D+";
    /**
     * Adjacency list for Storing the data
     */
    public static HashSet<Character>[] keyboard;
    /**
     * Helper bifunction to clean the input for validation.
     */
    BiFunction<String, String, String> cleanInput = (phone, pattern) -> phone.replaceAll(PATTERN, "");

    Map<Character,Character> charMap=new HashMap();

    /**
     * Initialize the classes for unit test.
     */
    @BeforeEach
    public void init() {
        mEasyToDialValidation = new EasyToDialValidation();
        keyboard = new HashSet[NUMBER_OF_CHARACTERS];
        buildKeyboard(keyboard);
    }

    @Test
    public void validatePhoneNumberPositiveTest() {
        boolean result = mEasyToDialValidation.isValidPhoneNumber("123-4567");
        Assertions.assertEquals(true, result);
    }

    @Test
    public void validatePhoneNumberNegativeTest() {
        boolean result = mEasyToDialValidation.isValidPhoneNumber("123-a567");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void validatePhoneNumberEmptyTest() {
        boolean result = mEasyToDialValidation.isValidPhoneNumber("");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void isEasyToDialPositiveTest() {
        boolean result = mEasyToDialValidation.isEasyToDial("254-7096");
        Assertions.assertEquals(true, result);
        boolean result1 = mEasyToDialValidation.isEasyToDial("554-7521");
        Assertions.assertEquals(true, result1);
    }

    @Test
    public void isEasyToDialNegativeTest() {
        boolean result = mEasyToDialValidation.isEasyToDial("280-6547");
        Assertions.assertEquals(false, result);
        boolean result1 = mEasyToDialValidation.isEasyToDial("355-8123”");
        Assertions.assertEquals(false, result1);
    }

    /**
     * Creates the adjacency set for keyboard
     *
     * @param sets Arrays of Hashset to store the adjacency of keyboard
     */
    private void buildKeyboard(HashSet<Character>[] sets) {
        HashSet<Character> zeroSet = new HashSet<>();
        zeroSet.add('8');
        zeroSet.add('7');
        zeroSet.add('9');
        sets[0] = zeroSet;

        HashSet<Character> oneSet = new HashSet<>();
        oneSet.add('2');
        oneSet.add('4');
        oneSet.add('5');
        sets[1] = oneSet;

        HashSet<Character> twoSet = new HashSet<>();
        twoSet.add('1');
        twoSet.add('3');
        twoSet.add('4');
        twoSet.add('5');
        twoSet.add('6');
        sets[2] = twoSet;

        HashSet<Character> threeSet = new HashSet<>();
        threeSet.add('2');
        threeSet.add('5');
        threeSet.add('6');
        sets[3] = threeSet;

        HashSet<Character> fourSet = new HashSet<>();
        fourSet.add('1');
        fourSet.add('2');
        fourSet.add('5');
        fourSet.add('7');
        fourSet.add('8');
        sets[4] = fourSet;


        HashSet<Character> fiveSet = new HashSet<>();
        fiveSet.add('1');
        fiveSet.add('2');
        fiveSet.add('3');
        fiveSet.add('4');
        fiveSet.add('5');
        fiveSet.add('6');
        fiveSet.add('7');
        fiveSet.add('8');
        fiveSet.add('9');
        sets[5] = fiveSet;


        HashSet<Character> sixSet = new HashSet<>();
        sixSet.add('2');
        sixSet.add('3');
        sixSet.add('5');
        sixSet.add('8');
        sixSet.add('9');
        sets[6] = sixSet;

        HashSet<Character> sevenSet = new HashSet<>();
        sevenSet.add('4');
        sevenSet.add('5');
        sevenSet.add('8');
        sevenSet.add('0');
        sets[7] = sevenSet;

        HashSet<Character> eightSet = new HashSet<>();
        eightSet.add('0');
        eightSet.add('4');
        eightSet.add('5');
        eightSet.add('6');
        eightSet.add('7');
        eightSet.add('9');
        sets[8] = eightSet;

        HashSet<Character> nineSet = new HashSet<>();
        nineSet.add('0');
        nineSet.add('5');
        nineSet.add('6');
        nineSet.add('8');
        sets[9] = nineSet;
    }

    /**
     * Easy to dial function what actually verifies a phone number is easy to dial or not
     *
     * @param phone Phone Number
     * @return boolean True for easy to dial and false otherwise
     */
    public boolean isEasyToDial(String phone) throws IllegalArgumentException {
        if (!isValidPhoneNumber(phone)) throw new IllegalArgumentException("Input is not correct");
        return helper(1, cleanInput.apply(phone, PATTERN));
    }

    /**
     * Helper function to recursively call the function
     */
    private boolean helper(int start, String input) {
        if (start == NUMBER_LEN)
            return true;
        char c = input.charAt(start - 1);

        if (keyboard[Integer.valueOf(String.valueOf(c))].contains(input.charAt(start)))
            return helper(start + 1, input);
        return false;
    }

    /**
     * Validate the phone number by cleaning and checking the length.
     */
    public boolean isValidPhoneNumber(String phone) {
        if (phone == null) return false;
        String pNumber = cleanInput.apply(phone, "\\D+");
        if (pNumber.length() != NUMBER_LEN) return false;
        return true;
    }

}
