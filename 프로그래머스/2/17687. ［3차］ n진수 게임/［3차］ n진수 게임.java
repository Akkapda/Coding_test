class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int turn = 0;
        while(true) {
            String temp = Integer.toString(num, n);
            for(int j = 0; j < temp.length(); j++) {
                if (answer.length() == t) {
                    break;
                } else if (turn == p - 1) {
                    //내 차례면?
                    answer = answer + temp.charAt(j);
                }
                turn++;
                turn = turn % m;
            }
            if (answer.length() == t) {
                break;
            }
            num++;
        }
        answer = answer.toUpperCase();
        return answer;
    }
}