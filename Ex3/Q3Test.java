package ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q3Test {

    @Test
    void mySplitTest() {
        int[] test = {5,21,8,15,7};
        assertTrue(Q3.mySplit(test));
        int[] test2 = {1,1,2,3,4,5,6};
        assertTrue(Q3.mySplit(new int[] {1,1}));
        assertFalse(Q3.mySplit(new int[] {1,1,1}));
        assertTrue(Q3.mySplit(new int[] {2,4,2}));
        assertTrue(Q3.mySplit(new int[] {5,21,8,15,7}));
        assertFalse(Q3.mySplit(new int[] {15,10,5}));
        assertTrue(Q3.mySplit(new int[] {15,8,7}));
        assertFalse(Q3.mySplit(new int[] {3,3}));
        assertFalse(Q3.mySplit(new int[] {5,5}));
        assertTrue(Q3.mySplit(new int[] {3,4,6,2,15}));
        assertTrue(Q3.mySplit(new int[] {}));
    }
}
