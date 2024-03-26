import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //i에서 하나를 골랐을 때 그 위에 한 개 혹은 두 개의 수까지의 합을 구한다.
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        dp[0][0] = Integer.parseInt(br.readLine());

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int counter = 0;
            while(st.hasMoreTokens()) {
                dp[i][counter] = Integer.parseInt(st.nextToken());
                counter++;
            }
            for(int j = 0; j < counter; j++) {
                if (j < 1) {
                    //좌측 끝
                    dp[i][j] = dp[i][j] + dp[i - 1][j];
                } else if (j == counter - 1) {
                    //우측 끝
                    dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
                } else {
                    //위쪽 라인의 좌측과 우측의 최대값
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
                }
            }
        }
        int temp = dp[n - 1][0];
        for(int i = 1; i < n; i++) {
            if (dp[n - 1][i] != 0) {
                if (temp < dp[n - 1][i]) {
                    temp = dp[n - 1][i];
                }
            } else break;
        }

        bw.write(temp + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
