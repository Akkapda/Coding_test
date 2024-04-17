class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (i > 0) {
                        //상단
                        if (board[i - 1][j] == 0) {
                            board[i - 1][j] = 2;
                        }
                        //좌측상단
                        if (j > 0 && board[i - 1][j - 1] == 0) {
                            board[i - 1][j - 1] = 2;
                        }
                        //우측상단
                        if (j < board[0].length - 1 && board[i - 1][j + 1] == 0) {
                            board[i - 1][j + 1] = 2;
                        }
                    }
                    //좌측
                    if (j > 0 && board[i][j - 1] == 0) {
                        board[i][j - 1] = 2;
                    }
                    //우측
                    if (j < board[0].length - 1 && board[i][j + 1] == 0) {
                        board[i][j + 1] = 2;
                    }
                    if (i < board.length - 1) {
                        //하단
                        if (board[i + 1][j] == 0) {
                            board[i + 1][j] = 2;
                        }
                        //좌측하단
                        if (j > 0 && board[i + 1][j - 1] == 0) {
                            board[i + 1][j - 1] = 2;
                        }
                        //우측하단
                        if (j < board[0].length - 1 && board[i + 1][j + 1] == 0) {
                            board[i + 1][j + 1] = 2;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}