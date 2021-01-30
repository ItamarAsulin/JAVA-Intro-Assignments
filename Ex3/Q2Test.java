package ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q2Test {

    @Test
    void reduceTest() {
        String str = "aaaabbbbccccddddsss";
        String test = Q2.reduce(str);
        assertEquals("abcds", test);
    }
}