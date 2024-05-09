class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        int length = 0;
        while(!"1".equals(s)) {
            while (s.contains("0")) {
                s = s.replaceFirst("0", "");
                answer[1]++;
            }
            length = s.length();
            s = Integer.toString(length, 2);
            answer[0]++;
        }
        return answer;
    }
}