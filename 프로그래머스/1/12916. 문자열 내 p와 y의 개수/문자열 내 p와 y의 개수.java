class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();

        int pCounter = 0;
        int yCounter = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p') {
                pCounter++;
            } else if (c == 'y') {
                yCounter++;
            }
        }
        if (pCounter != yCounter) {
            answer = false;
        }

        return answer;
    }
}