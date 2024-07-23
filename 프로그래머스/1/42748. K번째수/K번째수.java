import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        for(int index = 0; index < commands.length; index++) {
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            int[] arr = new int[j - i + 1];
            int start = 0;
            for(int q = i - 1; q < j; q++) {
                arr[start++] = array[q];
            }
            Arrays.sort(arr);
            answer[answerIndex++] = arr[k - 1];
        }
        return answer;
    }
}