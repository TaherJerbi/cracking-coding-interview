import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cracking.interview.ArraysAndStrings;

public class ArraysAndStringsTest {

    @Test
    public void isUnique() {
        assertTrue(ArraysAndStrings.isUnique("123"));
        assertFalse(ArraysAndStrings.isUnique("111"));
        assertTrue(ArraysAndStrings.isUnique(""));
        assertTrue(ArraysAndStrings.isUnique("1"));
        assertFalse(ArraysAndStrings.isUnique("1 1"));
    }

    @Test
    public void checkPermutation() {
        boolean nullCondition = ArraysAndStrings.checkPermutation(null, null);
        assertFalse(nullCondition);

        boolean trueCase = ArraysAndStrings.checkPermutation("123", "321");
        assertTrue(trueCase);

        boolean falseCase = ArraysAndStrings.checkPermutation("123", "3214");
        assertFalse(falseCase);
    }

}
