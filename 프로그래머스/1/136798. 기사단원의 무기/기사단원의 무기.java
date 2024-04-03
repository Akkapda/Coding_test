class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int devisorCount = 0;
            int sqrt = (int) Math.sqrt(i);
            for(int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    devisorCount++;
                    if (i / j != j) {
                        devisorCount++;
                    }
                }
            }
            //체크 후 limit보다 높으면 power를 입력하고
            //아니면 devisorCount를 넣는다.
            if (devisorCount > limit) {
                answer += power;
            } else {
                answer += devisorCount;
            }
        }
        return answer;
    }
}