package ex3;

public class Q4 {
    public static int[][] sumOfNeighbours(int[][] mat) {
        int[][] biggerMat = biggerMat(mat);
        int[][] summedMat = new int[mat.length][mat[0].length];
        for (int i = 1; i < biggerMat.length -1; i++) {
            for (int j = 1; j < biggerMat[i].length -1; j++) {
                int sum = 0;
                sum +=( biggerMat[i-1][j-1] + biggerMat[i-1][j] + biggerMat[i-1][j+1]+ biggerMat[i][j-1] + biggerMat[i][j+1] + biggerMat[i+1][j-1] + biggerMat[i+1][j] + biggerMat[i+1][j+1]);
                summedMat [i-1][j -1] = sum;
            }
        }
        return summedMat;

    }

    public static int[][] biggerMat(int[][] mat) {
        int[][] output = new int[mat.length + 2][mat[0].length + 2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                output[i + 1][j + 1] = mat[i][j];
            }
        }
        return output;
    }

    public static int[][] reducedMat(int[][] mat) {
        int[][] reducedMat = new int[mat.length - 2][mat[0].length - 2];
        for (int i = 0; i < reducedMat.length; i++) {
            for (int j = 0; j < reducedMat[i].length; j++) {
                reducedMat[i][j] = mat[i + 1][j + 1];
            }

        }
        return reducedMat;
    }
}
