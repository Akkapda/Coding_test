import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int r;
    public static int c;


    public static void main(String[] args) throws IOException {
        //방 크기 입력
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //로봇청소기 위치 및 방향 입력
        s = br.readLine();
        st = new StringTokenizer(s);
        //좌표
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        //방향 0북 1동 2남 3서
        int d = Integer.parseInt(st.nextToken());
        //방 정보 입력
        int room[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //올바르게 입력했는지 체킹(문제에 필요하진않음)
        if (room[r][c] == 1) {
            System.out.println("현재 위치가 청소된 상태입니다. 올바르게 입력하세요.");
        }
        /*
        1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        2.현재 칸의 주변4칸 중 청소되지 않은 빈 칸이 없는 경우,
        2-1.바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        2-2.바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        3.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
        3-1.반시계 방향으로 90도 회전한다.
        3-2.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        3-3.1번으로 돌아간다.
        */
        //작동 알고리즘을 위한 변수
        boolean run = true;
        int cleaningCOUNT = 0;

        while(run) {
            //1.현재 칸 청소
            if (room[r][c] == 0) {
                //청소한 칸은 2로 바꿔서 기록한다.
                room[r][c] = 2;
                cleaningCOUNT++;
            }
            else {
                if (Check4Way(room, n, m, r, c)) {
                    //2.현재 칸의 주변4칸 중 청소되지 않은 빈 칸이 없는 경우,
                    if (!Backmove(room, d, n, m, r, c)) {
                        //2-1.바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                        //위의 Backmove 메소드에서 후진처리가 가능하다면 후진처리를 한 상태이다.
                        //2-2.바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                        break;
                    }
                }
                else {
                    //3.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                    //3-1.반시계 방향으로 90도 회전한다.
                    d = (d + 3) % 4;
                    //3-2.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                    if (CheckFront(room, d, n, m, r, c)) {
                        continue;
                    }

                }
            }
        }

        bw.write(cleaningCOUNT + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean Check4Way(int room[][], int n, int m, int r, int c) {
        //4방향에 청소상태를 확인
        //북쪽 체크
        if (r - 1 >= 0 && room[r - 1][c] == 0) {
            return false;
        }
        //동쪽 체크
        else if (c + 1 < m && room[r][c + 1] == 0) {
            return false;
        }
        //남쪽 체크
        else if (r + 1 < n && room[r + 1][c] == 0) {
            return false;
        }
        //서쪽 체크
        else if (c - 1 >= 0 && room[r][c - 1] == 0) {
            return false;
        }
        else return true;
    }
    public static boolean Backmove(int room[][], int d, int n, int m, int r, int c) {
        //후진메소드
        boolean canMove = true;
        //북쪽을 보고 있을 때
        if (d == 0) {
            if (r + 1 < n && room[Main.r + 1][Main.c] != 1) {
                Main.r = r + 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
        //동쪽
        else if (d == 1) {
            if (c - 1 >= 0 && room[Main.r][Main.c - 1] != 1) {
                Main.c = c - 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
        //남쪽
        else if (d == 2) {
            if (r - 1 >= 0 && room[Main.r - 1][Main.c] != 1) {
                Main.r = r - 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
        //서쪽
        else {
            if (c + 1 < m && room[Main.r][Main.c + 1] != 1) {
                Main.c = c + 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
    }
    public static boolean CheckFront(int room[][], int d, int n, int m, int r, int c) {
        //전진메소드 후진과 다르게 청소도 되어있지 않은지 체크해야한다.
        boolean canMove = true;
        //북쪽을 보고 있을 때
        if (d == 0) {
            if (r - 1 >= 0 && room[r - 1][c] == 0) {
                Main.r = r - 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
        //동쪽
        else if (d == 1) {
            if (c + 1 < m && room[r][c + 1] == 0) {
                Main.c = c + 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
        //남쪽
        else if (d == 2) {
            if (r + 1 < n && room[r + 1][c] == 0) {
                Main.r = r + 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
        //서쪽
        else {
            if (c - 1 >= 0 && room[r][c - 1] == 0) {
                Main.c = c - 1;
                return canMove;
            }
            else {
                canMove = false;
                return canMove;
            }
        }
    }
}
