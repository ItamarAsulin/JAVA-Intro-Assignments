package ex3;

public class Q1 {
    public static String moveCharToLast(String str, char ch){
        if(str.length() == 1){
            return str;
        }
        if(str.charAt(0) == ch){
            return moveCharToLast(str.substring(1), ch) + ch;
        }
        else{
            return str.charAt(0) +moveCharToLast(str.substring(1), ch);
        }
    }
}
