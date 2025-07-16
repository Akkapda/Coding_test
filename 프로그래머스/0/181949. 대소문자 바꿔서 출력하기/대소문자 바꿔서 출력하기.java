import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String answer = "";
        
        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (Character.isLowerCase(c)) {
                answer = answer + Character.toString(Character.toUpperCase(c));
            } 
            else {
                answer = answer + Character.toString(Character.toLowerCase(c));
            }
        }
        
        System.out.println(answer);
    }
}