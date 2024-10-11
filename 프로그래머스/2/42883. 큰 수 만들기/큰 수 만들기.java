class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        // 남겨야 할 문자의 개수
        int keep = number.length() - k;
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            // 스택에 있는 마지막 문자가 현재 문자보다 작으면 제거하고 k 감소
            while (k > 0 && answer.length() > 0 && answer.charAt(answer.length() - 1) < c) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }
            
            // 새로운 문자를 추가
            answer.append(c);
        }
        
        // 정답은 남겨야 할 문자 수만큼만 가져오기
        return answer.substring(0, keep);
    }
}
