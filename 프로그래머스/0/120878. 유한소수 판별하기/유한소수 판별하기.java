class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        for(int i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        while(true) {
            if (b % 2 != 0 && b % 5 != 0) {
                break;
            } else {
                if (b % 2 == 0) {
                    b /= 2;
                } else if (b % 5 == 0) {
                    b /= 5;
                }
            }
        }
        if (b > 1) {
            answer = 2;
        } else answer = 1;
        return answer;
    }
}