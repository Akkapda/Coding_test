import java.util.StringTokenizer;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for(int i = 0; i < quiz.length; i++) {
            StringTokenizer st = new StringTokenizer(quiz[i]);
            int num1 = Integer.parseInt(st.nextToken());
            String operator = st.nextToken();
            int num2 = Integer.parseInt(st.nextToken());
            st.nextToken();
            int result = Integer.parseInt(st.nextToken());
            if (operator.equals("-")) {
                if (result == num1 - num2) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            } else {
                if (result == num1 + num2) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }
        }
        return answer;
    }
}