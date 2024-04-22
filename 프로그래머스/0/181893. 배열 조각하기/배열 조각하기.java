class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer;
        int left = 0;
        int right = arr.length - 1;
        for(int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                //짝수
                right = left + query[i];
            } else {
                //홀수
                left = left + query[i];
            }
        }
        answer = new int[right - left + 1];
        int index = 0;
        for(int i = left; i <= right; i++) {
            answer[index++] = arr[i];
        }
        return answer;
    }
}