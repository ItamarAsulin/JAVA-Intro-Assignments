package ex3;

public class Q6 {
    public static String vigenereCipherText(String str, String key) {
        String cipheredText = recursionForVigenerer(str, key);
        return cipheredText;
    }

    public static String recursionForVigenerer(String str, String key) {
        String cipheredString = "";
        if (key.length() >= str.length()) {
            for (int i = 0; i < str.length(); i++) {
                if ((int) str.charAt(i) == 32)
                    cipheredString += " ";
                else {
                    int howManySteps = (int) key.charAt(i) - 97;
                    if (str.charAt(i) + howManySteps > 122) {
                        int circleSteps = 97 + (str.charAt(i) + howManySteps) - 123;
                        char cipheredChar = (char) circleSteps;
                        cipheredString += cipheredChar;
                    } else {
                        char cipheredChar = (char) (howManySteps + str.charAt(i));
                        cipheredString += cipheredChar;
                    }

                }
            }
            return cipheredString;
        } else {
            for (int i = 0; i < key.length(); i++) {
                if ((int) str.charAt(i) == 32)
                    cipheredString += " ";
                else {
                    int howManySteps = (int) key.charAt(i) - 97;
                    if (str.charAt(i) + howManySteps > 122) {
                        int circleSteps = 97 + (str.charAt(i) + howManySteps) - 123;
                        char cipheredChar = (char) circleSteps;
                        cipheredString += cipheredChar;
                    } else {
                        char cipheredChar = (char) (howManySteps + str.charAt(i));
                        cipheredString += cipheredChar;
                    }
                }
            }
            return cipheredString + recursionForVigenerer(str.substring(key.length()), key);
        }

    }

    public static String vigenereDecipherText(String str, String key) {
        String decipheredText = recursionForDecipheringText(str, key);
        return decipheredText;
    }

    public static String recursionForDecipheringText(String str, String key) {
        String cipheredString = "";
        if (key.length() >= str.length()) {
            for (int i = 0; i < str.length(); i++) {
                if ((int) str.charAt(i) == 32)
                    cipheredString += " ";
                else {
                    int howManySteps = (int) key.charAt(i) - 97;
                    if (str.charAt(i) - howManySteps < 97) {
                        int circleSteps = 123 - (97 - (str.charAt(i) - howManySteps));
                        char cipheredChar = (char) circleSteps;
                        cipheredString += cipheredChar;
                    } else {
                        char cipheredChar = (char) (str.charAt(i) - howManySteps);
                        cipheredString += cipheredChar;
                    }

                }
            }
            return cipheredString;
        } else {
            for (int i = 0; i < key.length(); i++) {
                if ((int) str.charAt(i) == 32)
                    cipheredString += " ";
                else {
                    int howManySteps = (int) key.charAt(i) - 97;
                    if (str.charAt(i) - howManySteps < 97) {
                        int circleSteps = 123 - (97 - (str.charAt(i) - howManySteps));
                        char cipheredChar = (char) circleSteps;
                        cipheredString += cipheredChar;
                    } else {
                        char cipheredChar = (char) (str.charAt(i) - howManySteps);
                        cipheredString += cipheredChar;

                    }
                }
            }
            return cipheredString + recursionForDecipheringText(str.substring(key.length()), key);
        }

    }



}
