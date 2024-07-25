import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % 5]) {
                correct[0]++;
            }
        }
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == person2[i % 8]) {
                correct[1]++;
            }
        }
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == person3[i % 10]) {
                correct[2]++;
            }
        }
        int highScore = Math.max(Math.max(correct[0], correct[1]), correct[2]);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if (correct[i] == highScore) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i) + 1;
        }
        Arrays.sort(answer);
        return answer;
    }
}