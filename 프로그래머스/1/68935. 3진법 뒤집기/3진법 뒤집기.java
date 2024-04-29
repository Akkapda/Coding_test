class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n, 3);

        String temp = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            temp = temp.concat(s.charAt(i) + "");
        }

        int current = 1;
        for(int i = temp.length() - 1; i >= 0; i--) {
            answer += Integer.parseInt(temp.charAt(i) + "") * current;
            current *= 3;
        }
        return answer;
    }
}