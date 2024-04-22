class Solution {
    public int solution(int[] array) {
        int answer = 0;
        //배열 선언하고 1000번보고 1000번하면? 끝
        int[] counter = new int[1000];
        for(int i = 0; i < array.length; i++) {
            counter[array[i]]++;
        }
        
        int max = 0;
        
        for(int i = 0; i < counter.length; i++) {
            if (max < counter[i]) {
                max = counter[i];
                answer = i;
            }
        }
        
        int flag = 0;
        for(int i = 0; i < counter.length; i++) {
            if (max == counter[i]) {
                flag++;
            }
        }
        if (flag > 1) {
            answer = -1;
        }
        return answer;
    }
}