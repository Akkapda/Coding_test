import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        //정렬
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            //현재 인덱스의 인용 수
            int num = citations[i];
            System.out.println(num);
            //그 인용 수 이상 인용된 논문 개수
            int count = citations.length - i;
            if (num >= count) {
                answer = count;
                break;
            }
        }
        return answer;
    }
}