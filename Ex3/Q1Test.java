package ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1Test {

    @Test
    void moveCharToLast() {
        String a = "hello";
        String test = Q1.moveCharToLast(a, 'l');
        assertEquals("heoll", test);
    }
}