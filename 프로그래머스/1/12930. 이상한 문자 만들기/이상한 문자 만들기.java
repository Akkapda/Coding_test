import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        String answer = "";
        int t = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer = answer.concat(" ");
                t = 0;
            } else {
                if (t % 2 == 0) {
                    answer = answer.concat(Character.toUpperCase(c) + "");
                    t++;
                } else {
                    answer = answer.concat(Character.toLowerCase(c) + "");
                    t++;
                }
            }
        }
        return answer;
    }
}