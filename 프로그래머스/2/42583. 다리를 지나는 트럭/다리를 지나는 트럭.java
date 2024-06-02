import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //bridge_length는 다리를 건너는데 필요한 시간이기도 함
        //정해진 순서로 건너기 때문에 조합은 생각할 필요 없음
        //다리큐
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> time = new LinkedList<>();

        int end_cnt = 0;
        int sec = 1;
        int index = 0;
        while (true) {
            if (end_cnt == truck_weights.length) {
                break;
            }
            //1초당 한 싸이클 돌리기
            //내리는 것과 올리는 것은 같은 시간 내에 가능하니 내리는거 먼저 해야함
            if (!time.isEmpty()) {
                if (time.peek() == sec - bridge_length) {
                    //지나갈 시간만큼 지났음
                    bridge.remove();
                    time.remove();
                    end_cnt++;
                }
            }
            //다리에 트럭을 올리는 동작 (올라가있는 트럭과 올리려는 트럭이 weight 이하여야함)
            //올라간 트럭 무게 측정
            int onBridge = 0;
            if (!bridge.isEmpty()) {
                for(int num : bridge) {
                    onBridge += num;
                }
            }
            if (index < truck_weights.length) {
                if (weight >= onBridge + truck_weights[index]) {
                    //올릴 수 있다면?
                    bridge.add(truck_weights[index++]);
                    time.add(sec);
                }
            }

            sec++;
        }
        return sec - 1;
    }
}