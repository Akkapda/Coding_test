class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            answer++;
            while (answer % 3 == 0 || answer % 10 == 3) {
                answer++;
            }
            if (answer / 10 == 3) {
                answer = 40;
            } else if (answer / 10 == 13) {
                answer = 140;
            }
        }
        return answer;
    }
}