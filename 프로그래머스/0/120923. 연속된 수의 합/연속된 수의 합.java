class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = 1;
        int sum = 0;
        for(int i = 1; i <= num; i++) {
            sum += i;
        }
        
        int diff = total - sum;
        start += (diff / num);
        
        for(int i = 0; i < num; i++) {
            answer[i] = start++;
        }
        return answer;
    }
}