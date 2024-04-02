import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int cnt = 1;
        //조건 -> 증가해야함
        //무조건 커지는걸 잡으면?
        //반례 100 1 2 3 -> 123 (100으로 시작해선 못구함)
        //dp를 이용 -> i번째를 고른다
        //100 1 2 300 400 500 3 4 5 6 -> (3에서 i - 4까지 본다? 불가능)
        //dp에 집어넣는데, 어디로 들어갈 수 있는지 확인
        //ex) 100이 먼저 들어가고 1은 100보다 작으니 100의 자리에 1이 들어감
        //2 는 1보다 크니 1 다음에 들어가는 식
        //3까지 왔을 때 300의 자리에 3이 들어가야 함
        dp[0] = sequence[0];
        for(int i = 1; i < n; i++) {
            int temp = sequence[i];
            if (dp[cnt - 1] < temp) {
                dp[cnt] = temp;
                cnt++;
            } else {
                // 적절한 위치 찾기
                for (int j = 0; j < cnt; j++) {
                    if (dp[j] >= temp) {
                        dp[j] = temp;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
