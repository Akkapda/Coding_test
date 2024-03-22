import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] schedule;
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력받기
        n = Integer.parseInt(br.readLine());
        schedule = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

         scheduling(0, 0);

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
    public static void scheduling(int day, int money) {
        //dfs를 하면?
        if (day >= n) {
            answer = Math.max(money, answer);
            return;
        }
        if (day + schedule[day][0] <= n) {
            scheduling(day + schedule[day][0], money + schedule[day][1]);
        } else {
            scheduling(day + schedule[day][0], money);
        }
        scheduling(day + 1, money);
    }
}
