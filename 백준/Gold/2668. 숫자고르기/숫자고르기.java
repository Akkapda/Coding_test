import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] numArray;
    static boolean[] visitArray;
    static ArrayList answer = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        numArray = new int[n + 1];
        visitArray = new boolean[n + 1];

        for(int i = 1; i <=n; i++) {
            numArray[i] = Integer.parseInt(br.readLine());
        }
        //꼬리가 물리면 완성
        for(int i = 1; i <= n; i++) {
            dfs(i, i);
        }

        bw.write(answer.size() + "\n");
        for(Object num : answer) {
            bw.write(num + "\n"); // 각 요소 출력
        }

        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int current, int start) {
        if (!visitArray[current]) {
            visitArray[current] = true;
            if (numArray[current] == start || !visitArray[numArray[current]]) {
                dfs(numArray[current], start);
            }
            if (numArray[current] == start) {
                answer.add(start);
            }
            visitArray[current] = false;
        }
    }
}
