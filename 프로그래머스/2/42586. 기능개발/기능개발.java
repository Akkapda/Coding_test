import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //큐를 사용해서 각 프로그레스마다 배포를 제한할 수 있는 방식으로 가야한다.
        //i번째 프로그레스가 i - 1 프로그레스보다 작으면 i - 1번째의 날짜에 같이 배포하는 식

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();

        //큐에 프로그레스 완료날짜를 전부 넣어준다.
        for(int i = 0; i < progresses.length; i++) {
            int day = 0;
            int temp = (100 - progresses[i]) % speeds[i];
            day += (100 - progresses[i]) / speeds[i];
            if (temp > 0) {
                day++;
            }
            queue.add(day);
        }

        //큐에 모든 배포가능 날짜를 넣었음
        //이걸 위에다 합쳐서 구현하면 편하긴한데 보기가 복잡함
        int prev = 0;
        int prevIndex = -1;
        for(int i = 0; i < progresses.length; i++) {
            int day = queue.remove();
            if (prev >= day) {
                //이전 것이 배포되어야 배포 가능
                array.set(prevIndex, array.get(prevIndex) + 1);
            } else {
                array.add(1);
                prev = day;
                prevIndex++;
            }
        }

        int[] answer = new int[array.size()];

        int index = 0;
        for(int num : array) {
            answer[index++] = num;
        }
        
        return answer;
    }
}