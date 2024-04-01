import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        //3개 연속으로 못먹음
        //몇개를 안먹든 상관 x
        // i - 3, i - 1을 먹는다 - 1번
        // i - 2, 를 먹는다 - 2번
        // i번째를 안먹는 경우 - 3번
        //가장 큰걸 먹는다
        int[] drink = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        if (n < 3) {
            //잔이 두 개 이하인 경우
            for(int i : drink) {
                answer += i;
            }
        } else if (n == 3) {
            //잔이 세 개인 경우
            for(int i = 0; i < n; i++) {
                answer += drink[i];
            }
            answer -= Math.min(Math.min(drink[0], drink[1]), drink[2]);
        } else {
            //잔이 네 잔 이상, 기준점인 0 1 2 인덱스를 잡아준다.
            dp[0] = drink[0];
            dp[1] = dp[0] + drink[1];
            for(int i = 0; i < 3; i++) {
                dp[2] += drink[i];
            }
            dp[2] -= Math.min(Math.min(drink[0], drink[1]), drink[2]);

            for(int i = 3; i < n; i++) {
                //1번 경우와 2, 3번 경우중 max를 받는다
                dp[i] = Math.max(Math.max(dp[i - 3] + drink[i - 1] + drink[i], dp[i - 2] + drink[i]), dp[i - 1]);
            }
            answer = dp[n - 1];
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
