package ex3;

public class Q5 {
    public static String caesarCipherText(String str, int key) {
        String newCipheredtText = "";
        for (int i = 0; i < str.length(); i++) {
            if (key > 26 || key < -26) {
                return "-1";
            } else if ((int) str.charAt(i) == 32) {
                newCipheredtText += " ";
            } else if ((int) str.charAt(i) + key == 122) {
                newCipheredtText += "z";
            } else if ((int) str.charAt(i) + key == 97) {
                newCipheredtText += "a";
            } else if ((int) str.charAt(i) + key > 122) {
                int greaterThan122Num = 96 + (((int) str.charAt(i) + key) - 122);
                char greaterThan122Char = (char) greaterThan122Num;
                newCipheredtText += greaterThan122Char;
            } else if ((int) str.charAt(i) + key < 97) {
                int smallerThan97Int = 123 - (97 - ((int) str.charAt(i) + key));
                char smallerThan97Char = (char) smallerThan97Int;
                newCipheredtText += smallerThan97Char;

            } else {
                int addToCihperInt = (int) str.charAt(i) + key;
                char addToCipherChar = (char) addToCihperInt;
                newCipheredtText += addToCipherChar;
            }
        }
        return newCipheredtText;
    }
}
