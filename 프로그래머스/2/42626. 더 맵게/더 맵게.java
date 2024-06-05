import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for(long num : scoville) {
            priorityQueue.add(num);
        }

        while(true) {
            long s1 = priorityQueue.poll();
            if (s1 >= K) {
                break;
            } else if (priorityQueue.size() < 1) {
                if (s1 < K) {
                    answer = -1;
                }
                break;
            }
            long s2 = priorityQueue.poll();
            long temp = s1 + (s2 * 2);
            priorityQueue.add(temp);
            answer++;
        }
        
        return answer;
    }
}