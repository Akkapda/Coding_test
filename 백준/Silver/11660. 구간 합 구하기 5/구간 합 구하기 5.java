import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                if (j == 0) {
                    numbers[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    numbers[i][j] = numbers[i][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;

            if (y1 == 1) {
                for(int j = x1; j <= x2; j++) {
                    sum += numbers[j - 1][y2 - 1];
                }
            } else {
                for(int j = x1; j <= x2; j++) {
                    sum += numbers[j - 1][y2 - 1] - numbers[j - 1][y1 - 2];
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}