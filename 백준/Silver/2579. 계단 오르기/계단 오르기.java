import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //계단을 3연속으로 못 밟는다.

        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        //n이 4보다 작을경우
        if (n == 1) {
            dp[0] = stair[0];
        } else if (n == 2) {
            dp[1] = stair[0] + stair[1];
        } else if (n == 3) {
            dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
        } else {
            dp[1] = stair[0] + stair[1];
            dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
            //124, 134
            dp[3] = Math.max(stair[0] + stair[1] + stair[3], stair[0] + stair[2] + stair[3]);

            if (n > 4) {
                for(int i = 4; i < n; i++) {

                    dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);

                }
            }
        }
        answer = dp[n - 1];
        System.out.println(answer);
    }
}
