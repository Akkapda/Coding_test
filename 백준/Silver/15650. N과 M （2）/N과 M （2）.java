import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //n 입력
        int m = Integer.parseInt(st.nextToken());   //m 입력

        arr = new int[m];           //출력 될 값을 저장하기 위한 배열

        dfs(n, m, 1, 0);

        System.out.print(sb);

        br.close();
    }

    public static void dfs(int n, int m, int cnt, int depth) throws IOException {
        //탐색이 끝난 경우
        //cnt가 m과 같으면 저장
        if (depth == m) {
            Arrays.sort(arr);
            for (int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }
        //1부터 시작했으므로 i < n 이 아닌 i <= n
        for (int i = cnt; i <= n; i++) {
            arr[depth] = i;
            dfs(n, m, i + 1, depth + 1);
        }
    }
}
