import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int player = stages.length;
        int start = 0;
        
        //현재 스테이지 정렬
        Arrays.sort(stages);
        
        //실패율 저장할 맵
        Map<Integer, Double> fail = new HashMap<>();
        
        //i = 스테이지
        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            player = stages.length - start;
            for(int j = start; j < stages.length; j++) {
                if (stages[j] > i) {
                    start = j;
                    break;
                } else if (stages[j] == i) {
                    cnt++;
                } else {
                    break;
                }
            }
            //실패한 사람
            System.out.println(cnt);
            System.out.println(player);
            double failure = 0;
            if (player != 0) {
                failure = (double)cnt / (double)player;
            }
            
            fail.put(i, failure);
        }
        
        List<Integer> keySet = new ArrayList<>(fail.keySet());
        
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return fail.get(o2).compareTo(fail.get(o1));
            }
        });
        
        int index = 0;
        
        for(int n : keySet) {
            answer[index++] = n;
        }
        
        System.out.println(keySet);
        
        return answer;
    }
}