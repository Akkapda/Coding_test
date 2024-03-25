import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2) -> {return o1[1]-o2[1];});
        int missile = -1;
        for(int[] target : targets){
            if(missile == -1){
                answer++;
                missile = target[1];
            }

            if(target[0] < missile && target[1] >= missile) continue;

            answer++;
            missile = target[1];
        }
        return answer;
    }
}