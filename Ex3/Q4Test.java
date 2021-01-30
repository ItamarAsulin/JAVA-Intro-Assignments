package ex3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q4Test {

    @Test
    void sumOfNeighboursTest() {
        int[][] mat = {{3,5,7,5},{-4,2,10,11},{9,-50,3,60}};
        int[][] summedMat = Q4.sumOfNeighbours(mat);
        int [][] expectedResult = {{3, 18, 33, 28}, {-31, -17, 43, 85}, {-52, 20, 33, 24}};
        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult[i].length ; j++) {
                assertEquals(summedMat[i][j], expectedResult[i][j]);
            }
        }
    }
}