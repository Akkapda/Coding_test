class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        for(int i = 0; i < A.length(); i++) {
            if (A.equals(B)) {
                break;
            } else {
                A = Character.toString(A.charAt(A.length() - 1)) + A.substring(0, A.length() - 1);
                answer++;
            }
        }
        if (answer == A.length()) {
            answer = -1;
        }
        return answer;
    }
}