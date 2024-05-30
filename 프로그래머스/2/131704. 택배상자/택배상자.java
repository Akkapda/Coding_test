import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int box = 1;
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        while (true) {
            if (index > order.length - 1) {
                break;
            }
            if (order[index] < box) {
                if (!stack.isEmpty() && stack.peek() != order[index]) {
                    break;
                }
            }
            if (order[index] != box) {
                //현재박스와 다르면?
                if (!stack.isEmpty() && stack.peek() != order[index]) {
                    //스택에 차있고 현재박스와 상관없으면?
                    stack.push(box++);
                } else if (!stack.isEmpty() && stack.peek() == order[index]) {
                    //스택에 차있고 현재박스면?
                    answer++;
                    index++;
                    stack.pop();
                } else {
                    stack.push(box++);
                }
            } else {
                answer++;
                box++;
                index++;
            }
        }
        return answer;
    }
}