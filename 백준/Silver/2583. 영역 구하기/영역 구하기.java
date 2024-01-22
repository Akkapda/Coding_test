import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static int[][] board;
    static int count = 2;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[m][n];

        int x1,y1,x2,y2; //사각형의 꼭짓점
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine()); //사각형 받기
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int j = y1; j < y2; j++) {
                for(int q = x1; q < x2;q++) {
                    board[j][q] = 1;
                }
            }
        }

        //보드에 빈칸 채우기 재귀함수
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    drawBoard(i, j);
                    count++;
                }
            }
        }
        //보드의 채운 영역 계산하기
        //영역의 개수는 count - 2을 하면 된다.
        //여기서 -2 인 이유는 재귀함수 돌릴 때 마지막에서 ++를 하고 나오기 때문에 최종적으로 개수의 +2가 된다. (39번째 줄)
        int temp = 2;
        int[] volume = new int[count - 2];

        while (temp <= count) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (board[i][j] == temp)
                        volume[temp - 2]++;
                }
            }
            temp++;
        }

        Arrays.sort(volume);

        bw.write((count - 2) + "\n");
        for(int i = 0; i < volume.length; i++) {
            bw.write(volume[i] + " ");
        }

        //보드 상태 체크용
//        bw.write("\n");
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                bw.write(board[i][j] + " ");
//            }
//            bw.write("\n");
//        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void drawBoard(int i, int j) {
        // 현재 자리가 0일 떄
        if (board[i][j] == 0) {
            board[i][j] = count;
        }
        else return;
        //여기서 index out이 나오지 않도록 조심한다.
        if (i + 1 < m) {
            drawBoard(i + 1, j);
        }
        if (i - 1 >=0) {
            drawBoard(i - 1, j);
        }
        if (j + 1 < n) {
            drawBoard(i, j + 1);
        }
        if (j - 1 >= 0) {
            drawBoard(i , j - 1);
        }
    }
}
