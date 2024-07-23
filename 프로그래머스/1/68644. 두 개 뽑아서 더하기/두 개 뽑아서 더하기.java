import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        Map<Integer, Integer> result = new HashMap<>();
        for(int num1 : map.keySet()) {
            for(int num2 : map.keySet()) {
                if (!result.containsKey(num1 + num2)) {
                    if (num1 != num2) {
                        result.put(num1 + num2, 1);
                    } else {
                        if (map.get(num1) > 1) {
                            result.put(num1 + num2, 1);
                        }
                    }
                }
            }
        }
        int[] answer = new int[result.keySet().size()];
        int i = 0;
        for(int num : result.keySet()) {
            answer[i++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
}