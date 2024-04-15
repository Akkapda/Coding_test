class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        //어떻게 풀까?
        //배열로 해서 풀면 간단하긴할 듯
        int[] array = new int[201];
        for(int i = 0; i < 3; i++) {
            for(int j = lines[i][0] + 100; j < lines[i][1] + 100; j++) {
                if (array[j] == 1) {
                    answer++;
                    array[j] = 2;
                } else if (array[j] == 0) {
                    array[j] = 1;
                }
            }
        }
        return answer;
    }
}