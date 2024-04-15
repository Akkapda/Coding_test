class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int temp = 1;
        int i = 0, j = 0;
        int direction = 0;
        while(temp <= n * n) {
            answer[i][j] = temp++;
            if (direction == 0) {
                if (j < n - 1 && answer[i][j + 1] == 0) {
                    j++;
                } else {
                    i++;
                    direction = 1;
                }
            } else if (direction == 1) {
                if (i < n - 1 && answer[i + 1][j] == 0) {
                    i++;
                } else {
                    j--;
                    direction = 2;
                }
            } else if (direction == 2) {
                if (j > 0 && answer[i][j - 1] == 0) {
                    j--;
                } else {
                    i--;
                    direction = 3;
                }
            } else if (direction == 3) {
                if (i > 0 && answer[i - 1][j] == 0) {
                    i--;
                } else {
                    j++;
                    direction = 0;
                }
            }
        }
        return answer;
    }
}