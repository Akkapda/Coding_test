import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        int cnt = 0;
        int currentPrice = k;
        for(int i = score.length - 1; i >= 0; i--) {
            //상자에 큰 순으로 담기
            //어차피 가장 비싸게 팔려면 비싼거로 최대치를 채워야함
            if (currentPrice > score[i]) {
                currentPrice = score[i];
            }
            cnt++;
            if (cnt == m) {
                cnt = 0;
                answer += currentPrice * m;
            }
        }

        System.out.println(answer);
        return answer;
    }
}