import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int desN, desM;
    static int[] dirN = {0, 1, 0, -1};
    static int[] dirM = {1, 0, -1, 0};
    static boolean[][][] visited; // [n][m][벽을 부순 상태]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        desN = Integer.parseInt(st.nextToken());
        desM = Integer.parseInt(st.nextToken());

        map = new int[desN][desM];
        visited = new boolean[desN][desM][2]; // 벽을 부수고 온 경우와 부수지 않고 온 경우를 분리하여 관리

        for (int i = 0; i < desN; i++) {
            String temp = br.readLine();
            for (int j = 0; j < desM; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1}); // x, y, 벽 부순 상태, 이동 거리
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int wall = current[2];
            int distance = current[3];

            if (x == desN - 1 && y == desM - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dirN[i];
                int ny = y + dirM[i];

                if (nx >= 0 && ny >= 0 && nx < desN && ny < desM) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][wall]) {
                        visited[nx][ny][wall] = true;
                        queue.offer(new int[]{nx, ny, wall, distance + 1});
                    } else if (map[nx][ny] == 1 && wall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new int[]{nx, ny, 1, distance + 1});
                    }
                }
            }
        }

        return -1; // 도착할 수 없는 경우
    }
}
