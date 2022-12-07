import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] chessPlate = new char[n][m];

        for(int i = 0; i < n; i++) {
            str = br.readLine();
            for(int j = 0; j < m; j++) {
                chessPlate[i][j] = str.charAt(j);
            }
        }
        int temp;
        int cnt = 50000;

        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                temp = Chess_Paint(chessPlate, i, j);
                if (temp < cnt) {
                    cnt = temp;
                }
            }
        }

        System.out.println(cnt);
    }

    public static int Chess_Paint(char[][] board, int startN, int startM) {
        int cnt_B = 0, cnt_W = 0;

        char[][] blackboard = new char[8][8];
        Make_Board(blackboard, 'B');
        char[][] whiteboard = new char[8][8];
        Make_Board(whiteboard, 'W');

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (board[startN + i][startM + j] != blackboard[i][j]) {
                    cnt_B++;
                }
                if (board[startN + i][startM + j] != whiteboard[i][j]) {
                    cnt_W++;
                }
            }
        }

        if (cnt_B > cnt_W) {
            return cnt_W;
        }
        else if (cnt_W >= cnt_B) {
            return cnt_B;
        }

        return 0;
    }

    public static void Make_Board(char[][] board, char start) {
        String blackstart = "BWBWBWBW";
        String whitestart = "WBWBWBWB";
        if (start == 'B') {
            for(int i = 0; i < board.length / 2; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    board[i * 2][j] = blackstart.charAt(j);
                    board[(i * 2) + 1][j] = whitestart.charAt(j);
                }
            }
        }
        else if (start == 'W') {
            for(int i = 0; i < board.length / 2; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    board[i * 2][j] = whitestart.charAt(j);
                    board[(i * 2) + 1][j] = blackstart.charAt(j);
                }
            }
        }
    }
}