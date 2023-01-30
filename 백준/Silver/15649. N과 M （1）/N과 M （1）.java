import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static boolean[] booleans;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //n 입력
        int m = Integer.parseInt(st.nextToken());   //m 입력

        arr = new int[m];             //출력 될 값을 저장하기 위한 배열
        booleans = new boolean[n];    //n번째 인덱스 조정을 위한 boolean 배열

        dfs(n, m, 0);

        System.out.print(sb);

        br.close();
    }

    public static void dfs(int n, int m, int depth) throws IOException {
        //탐색이 끝난 경우
        //sb로 arr배열을 입력해주고 return
        if (depth == m) {
            for (int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            //booleans 값이 false면 실행
            if (!booleans[i]) {
                booleans[i] = true;    //해당 값을 true로 변경해주고
                arr[depth] = i + 1;    //i = 0부터 였으므로 i + 1값을 arr의 현재 depth에 입력
                dfs(n, m, depth + 1);  //다음 depth로 재귀
                booleans[i] = false;
            }
        }
    }
}
