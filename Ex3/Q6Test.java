package ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q6Test {

    @Test
    void vigenereCipherTextTest() {
        String in = "a simple example";
        String out = "a zqqkpq rqaowti";
        assertTrue(out.equals(Q6.vigenereCipherText(in, "achievement")));
        in = "impressive student from ariel university";
        out = "pacfvzgvjv ggiulbg wycz rywrz bbvjvygvhp";
        assertTrue(out.equals(Q6.vigenereCipherText(in, "honor")));
        in = "test";
        out = "test";
        assertTrue(out.equals(Q6.vigenereCipherText(in, "a")));
    }

    @Test
    void vigenereDecipherTextTest() {
        String in = "a simple example";
        String key = "achievement";
        assertTrue(in.equals(Q6.vigenereDecipherText(Q6.vigenereCipherText(in,key),key)));
    }
}