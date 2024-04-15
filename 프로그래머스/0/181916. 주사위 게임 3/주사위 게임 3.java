import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] abcd = {a, b, c, d};
        Arrays.sort(abcd);

        if (abcd[0] == abcd[1] && abcd[1] == abcd[2] && abcd[2] == abcd[3]) {
            //네개가 다 맞음
            answer = abcd[0] * 1111;
        } else if (abcd[0] == abcd[1] && abcd[1] == abcd[2]) {
            answer = (int) Math.pow((10 * abcd[0]) + abcd[3], 2);
        } else if (abcd[1] == abcd[2] && abcd[2] == abcd[3]) {
            answer = (int) Math.pow((10 * abcd[1]) + abcd[0], 2);
        } else if (abcd[0] == abcd[1] && abcd[2] == abcd[3]) {
            answer = (abcd[0] + abcd[2]) * Math.abs(abcd[0] - abcd[2]);
        } else if (abcd[0] == abcd[1] || abcd[1] == abcd[2] ||
                abcd[2] == abcd[3] || abcd[0] == abcd[3]) {
            if (abcd[0] == abcd[1]) {
                answer = abcd[2] * abcd[3];
            } else if (abcd[1] == abcd[2]) {
                answer = abcd[0] * abcd[3];
            } else if (abcd[2] == abcd[3]) {
                answer = abcd[0] * abcd[1];
            } else {
                answer = abcd[0] * abcd[1];
            }
        } else {
            answer = abcd[0];
        }
        return answer;
    }
}