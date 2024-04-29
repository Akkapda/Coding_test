class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ') {
                answer = answer.concat(" ");
                continue;
            }
            if (current > 96) {
                current += n;
                current = (char) ((current % 97 % 26) + 97);
            } else {
                current += n;
                current = (char) ((current % 65 % 26) + 65);
            }
            answer = answer.concat(Character.toString(current));
        }
        return answer;
    }
}