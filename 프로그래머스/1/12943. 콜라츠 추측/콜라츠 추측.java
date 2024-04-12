class Solution {
    public int solution(int num) {
        int answer = 0;
        long num2 = num;
        if (num == 1) {
            return 0;
        }
        while(true) {
            if (num2 % 2 == 0) {
                num2 /= 2;
                answer++;
            }
            else {
                num2 *= 3;
                num2 ++;
                answer++;
            }
            if (num2 == 1) break;
            if (answer == 500) {
                return -1;
            }
        }
        return answer;
    }
}