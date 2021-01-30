package ex3;

public class Q2 {
    public static String reduce(String str){
        if(str.length() == 1){
            return str;
        }
        if(str.charAt(0) == str.charAt(1)){
            return reduce(str.substring(1));
        }
        else{
            return str.charAt(0) + reduce(str.substring(1));
        }
    }
}
