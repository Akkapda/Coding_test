import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];

        // 첫 번째 집의 RGB 비용 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken()); // R
        dp[0][1] = Integer.parseInt(st.nextToken()); // G
        dp[0][2] = Integer.parseInt(st.nextToken()); // B

        // 두 번째 집부터 마지막 집까지 최소 비용 계산
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 현재 집을 R로 칠했을 때의 최소 비용은, 이전 집을 G나 B로 칠했을 때의 최소 비용에 현재 비용을 더한 값
            dp[i][0] = r + Math.min(dp[i-1][1], dp[i-1][2]);
            // 현재 집을 G로 칠했을 때의 최소 비용은, 이전 집을 R나 B로 칠했을 때의 최소 비용에 현재 비용을 더한 값
            dp[i][1] = g + Math.min(dp[i-1][0], dp[i-1][2]);
            // 현재 집을 B로 칠했을 때의 최소 비용은, 이전 집을 R나 G로 칠했을 때의 최소 비용에 현재 비용을 더한 값
            dp[i][2] = b + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // 마지막 집까지 칠했을 때의 최소 비용 계산
        int minCost = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        bw.write(minCost + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
