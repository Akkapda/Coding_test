import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = numbers.length - 1; i > -1; i--) {
            //스택에 들어있는 경우?
            //스택peek랑 비교했을 때 number가 더 크거나 같은경우
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            //while에서 어차피 크거나 같은경우는 걸러진다?
            //number가 더 작으면?
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }

            stack.push(numbers[i]);
        }
        return answer;
    }
}