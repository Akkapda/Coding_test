class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {-1, 0, 1, 0};
        
        String currentColor = board[h][w];
        
        for(int i = 0 ;i < 4; i++) {
            if (h + directionY[i] >= 0 && w + directionX[i] >= 0 &&
                    h + directionY[i] < board.length && w + directionX[i] < board[0].length) {
                if (board[h + directionY[i]][w + directionX[i]].equals(currentColor)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}