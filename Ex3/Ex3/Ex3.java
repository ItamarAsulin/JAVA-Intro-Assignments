import java.lang.reflect.Array;
import java.util.*;


public class Ex3 {      // id : 208999888
    public static String myID(){
        return "208999888";
    }

    public static String moveCharToLast(String str, char ch) {
        if (str.length() < 1) {
            return "";
        }

        String newArrangedSubString = str.substring(1);

        if (str.indexOf(ch) == 0) {
            return moveCharToLast(newArrangedSubString, ch) + ch;
        } else {
            return str.charAt(0) + moveCharToLast(newArrangedSubString, ch);
        }

    }   // a function that moves all the given char appearances to the end of the string

    public static String reduce(String str) {
        String result = str;
        if (str.length() >= 2) {
            if (str.charAt(0) == str.charAt(1)) {
                result = reduce(str.substring(1));
            } else {
                result = str.charAt(0) + reduce(str.substring(1));
            }

        }
        return result;
    }   // a function that returns a string in which all the char who appeared two time or more in a row is reduced to one appearance

    public static boolean mySplit(int[] nums) {
        ArrayList<Integer> groupA = new ArrayList<Integer>();
        ArrayList<Integer> groupB = new ArrayList<Integer>();
        ArrayList<Integer> recievedArrayList = new ArrayList<Integer>();
        int reducedArrayLength = 1;
        int[] reducedArray = new int[reducedArrayLength];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0 && nums[i] % 5 != 0)
                recievedArrayList.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 5 == 0) {
                groupA.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0 && nums[i] % 5 != 0) {
                groupB.add(nums[i]);
            }

        }
        return divideIntoAllPossibleGroups(recievedArrayList, groupA, groupB);

    }   // a function that what givven an array checks if it is possible to divied it into two arrays such aa all the multiplies of 5 in one array and all multiplies of 3 in the other and all the other nubers can be divided in any way int order to get two arrays that the sum of their numbers is equal

    private static boolean divideIntoAllPossibleGroups(ArrayList<Integer> originalArray, ArrayList<    // recursive function for mySplit
            Integer> groupA, ArrayList<Integer> groupB) {
        if (originalArray.size() == 0) {
            int sumA = 0;
            int sumB = 0;
            for (Integer integer : groupA) {
                sumA += integer;
            }
            for (Integer integer : groupB) {
                sumB += integer;

            }
            return sumA == sumB;
        } else {
            Integer element = originalArray.get(originalArray.size() - 1);
            groupA.add(element);
            originalArray.remove(originalArray.size() - 1);
            if (divideIntoAllPossibleGroups(new ArrayList<Integer>(originalArray), new ArrayList<Integer>(groupA), new ArrayList<Integer>(groupB)))
                return true;
            else {
                groupA.remove(element);
                groupB.add(element);
                return divideIntoAllPossibleGroups(new ArrayList<Integer>(originalArray), new ArrayList<Integer>(groupA), new ArrayList<Integer>(groupB));
            }

        }


    }

    public static int[][] sumOfNeighbours(int[][] mat) {
        int[][] summedMat = new int[mat.length][mat[1].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0) { // top line
                    if (j == 0) //upper left corner
                        summedMat[i][j] = mat[i][j + 1] + mat[i + 1][j] + mat[i + 1][j + 1];
                    else if (j == mat[i].length - 1) //upper right corner
                        summedMat[i][j] = mat[i][j - 1] + mat[i + 1][j] + mat[i + 1][j - 1];
                    else  // top row without corners
                        summedMat[i][j] = mat[i][j - 1] + mat[i + 1][j - 1] + mat[i + 1][j] + mat[i + 1][j + 1] + mat[i][j + 1];

                } else if (i == mat.length - 1) { // bottom column
                    if (j == 0) // bottom left corner
                        summedMat[i][j] = mat[i][j + 1] + mat[i - 1][j] + mat[i - 1][j + 1];

                    else if (j == mat[i].length - 1) // bottom right corner
                        summedMat[i][j] = mat[i - 1][j] + mat[i - 1][j - 1] + mat[i][j - 1];

                    else  // bottom row
                        summedMat[i][j] = mat[i][j - 1] + mat[i][j + 1] + mat[i - 1][j] + mat[i - 1][j - 1] + mat[i - 1][j + 1];

                } else if (j == 0) { // left row without corners
                    summedMat[i][j] = mat[i - 1][j] + mat[i - 1][j + 1] + mat[i][j + 1] + mat[i + 1][j] + mat[i + 1][j + 1];
                } else if (j == mat[i].length - 1) { // right row without corners
                    summedMat[i][j] = mat[i][j - 1] + mat[i - 1][j] + mat[i - 1][j - 1] + mat[i + 1][j] + mat[i + 1][j - 1];
                } else {// every other case
                    summedMat[i][j] = mat[i][j - 1] + mat[i][j + 1] + mat[i - 1][j - 1] + mat[i - 1][j] + mat[i - 1][j + 1] + mat[i + 1][j - 1] + mat[i + 1][j] + mat[i + 1][j + 1];
                }
            }

        }
        return summedMat;
    }  // a function that when given a matriza returns a same size matriza in which all cells are the sum of the neighboring cells in the given matriza.

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
    }  // a function that receives a string and a key and ciphering the given string with the given key by cesar cipher method.

    public static String vigenereCipherText(String str, String key) {
        String cipheredText = recursionForVigenerer(str, key);
        return cipheredText;
    }// a function that receives a string and a key and ciphering the given string with the given key by vigenere cipher method.

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

    }  // a recursion function for vigenereCipherText

    public static String vigenereDecipherText(String str, String key) {
        String decipheredText = recursionForDecipheringText(str, key);
        return decipheredText;
    } //a function that receives a string and a key and deciphering the given string with the given key by vigenere cipher method.

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

    }  // a recursion function for vigenereDecipherText
}











