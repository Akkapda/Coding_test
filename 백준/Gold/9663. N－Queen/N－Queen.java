import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] queenPlace;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        queenPlace = new int[n];

        checkBoard(0);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void checkBoard(int row) throws IOException {
        if (row == n) {
            count++; //배치 성공
            return;
        }

        for (int col = 0; col < n; col++) {
            queenPlace[row] = col;
            if (isSafe(row)) {
                checkBoard(row + 1);
            }
        }
    }

    // 현재 퀸의 위치가 안전한지 확인
    public static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열 또는 대각선에 퀸이 있는지 확인
            if (queenPlace[i] == queenPlace[row] || Math.abs(queenPlace[row] - queenPlace[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

}
