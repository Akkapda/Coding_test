import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] array = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i) + "";
        }
        Arrays.sort(array, Comparator.reverseOrder());
        for(int i = 0; i < s.length(); i++) {
            answer += array[i];
        }
        return answer;
    }
}