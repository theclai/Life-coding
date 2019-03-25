package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.
 * <p>
 * Follow-up: Can you do this in linear time and constant space?
 */
public class FindTwoUnrepeatedNumbers_140 {
    FindTwoUnrepeatedNumbers_140 findTwoUnrepeatedNumbers;

    @BeforeEach
    public void init() {
        findTwoUnrepeatedNumbers = new FindTwoUnrepeatedNumbers_140();
    }

    @Test
    public void firstTwoOddNumbers() {
        int[] res = findTwoUnrepeatedNumbers.printTwoOdd(new int[]{4, 2, 4, 5, 2, 3, 3, 1}, 8);
        Assertions.assertEquals(5,res[0]);
        Assertions.assertEquals(1,res[1]);
    }

    public int[] printTwoOdd(int arr[], int size) {
        int xor2 = arr[0];
        int set_bit_no;
        int i;
        int n = size - 2;
        int x = 0, y = 0;
        for (i = 1; i < size; i++) {
            xor2 = xor2 ^ arr[i];
        }

        // find the set bit
        set_bit_no = xor2 & ~(xor2 - 1);
 /* Now divide elements in two sets:
            1) The elements having the
               corresponding bit as 1.
            2) The elements having the
               corresponding bit as 0.  */
        for (i = 0; i < size; i++) {
         /* XOR of first set is finally going
            to hold one odd occurring number x */
            if ((arr[i] & set_bit_no) > 0)
                x = x ^ arr[i];

         /* XOR of second set is finally going
            to hold the other odd occurring number y */
            else
                y = y ^ arr[i];
        }
        return new int[]{x, y};

    }
}

