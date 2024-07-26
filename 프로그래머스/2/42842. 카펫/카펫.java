class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int blocks = brown + yellow;
        for(int i = 1; i < 2000; i++) {
            for(int j = 1; j < 2000; j++) {
                if (i * j == blocks && (i - 2) * (j - 2) == yellow) {
                    if (i >= j) {
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }
        }
        return answer;
    }
}