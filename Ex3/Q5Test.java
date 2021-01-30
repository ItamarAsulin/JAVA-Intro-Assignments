package ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q5Test {

    @Test
    void caesarCipherTextTest() {
        String in = "abcdefghijklmnopqrstuvwxyz ";
        String out = "efghijklmnopqrstuvwxyzabcd ";
        assertTrue(out.equals(Q5.caesarCipherText(in, 4)));
        assertTrue(in.equals(Q5.caesarCipherText(Q5.caesarCipherText(in, 4),-4)));
        in = "zzz";
        out = "aaa";
        assertTrue(out.equals(Q5.caesarCipherText(in, 1)));
        assertTrue(in.equals(Q5.caesarCipherText(Q5.caesarCipherText(in, 1),-1)));
        in = "aaa";
        out = "zzz";
        assertTrue(out.equals(Q5.caesarCipherText(in, -1)));
        assertTrue(in.equals(Q5.caesarCipherText(Q5.caesarCipherText(in, -1),1)));
    }
}