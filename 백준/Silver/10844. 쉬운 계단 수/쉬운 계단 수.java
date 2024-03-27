import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //간단하게 i가 올라갈수록 자식숫자가 생긴다고 생각한다.
        //i는 i - 1의 경우에서 끝자리가 0이나 9 인경우 1개의 다음수가 생기고
        //ex i = 3이면 i가 2의 경우에서 10 -> 101로만 생성된다 (898)
        //그 외의 나머지 수는 양쪽으로 두 개 씩 생성된다.
        //끝의 자리수가 0이거나 9인 수를 만들어내는건 1과 8이다
        //i = 2의 경우 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98 에서
        //3으로 갈 때 0이나 9가 끝인 수를 만들어내는 경우의 수는
        // 21 -> 210, 78 -> 789, 98 - > 989
        //여기서 4로 갈 때 더 생긴다.
        //101 -> 1010, 121 -> 1210, 321 -> 3210, 678 -> 6789, 878 -> 8789, 898 -> 8989
        //이 패턴이 뭐인가?
        //1 -> 2 일 때
        //1은 0이 없었기 때문에 기준점으로 둔다. 그럼 2부터 보자면
        //2 -> 3 일 때
        //끝 값이 0이나 9인 경우가 2개이고 전체 수가 17개 이므로
        //17 * 2 - 2개 = 32
        //그러면 3 -> 4는
        //32 * 2 - 3개 = 61
        //여기서 1 ~ 9의 배열을 만들고 개수를 세면?
        int[][] dp = new int[n][10];
        dp[0][0] = 0;
        for(int i = 1; i < dp[0].length; i++) {
            // -> 1일때
            dp[0][i] = 1;
        }
        long answer = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % 1000000000;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % 1000000000;
                } else {
                    dp[i][j] = ((dp[i - 1][j - 1]% 1000000000) + (dp[i - 1][j + 1] % 1000000000)) % 1000000000;
                }
            }
        }
        for(int i = 0; i < dp[n - 1].length; i++) {
            answer += dp[n - 1][i];
        }

        bw.write(answer % 1000000000 + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
