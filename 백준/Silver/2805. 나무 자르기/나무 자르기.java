import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] trees;
    static int n;
    static long m, min, max, middle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new long[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        //정렬 완료 후 가장 단순히 m 만큼 남는 것은 가장 긴 나무에서 m 만큼 자르는 것이다.
        //따라서 mix = tallest tree - m으로 설정하고 간다 -> 시작부분에서는 문제의 h와 같다.
        //여기서 max는 가장 긴 나무로 한다. -> 가장 긴 나무를 전부 자르는 것은 모든 나무를 가져가는 것이므로 max 수치이다.
        max = trees[trees.length - 1];
        if (max - m < 0) {
            min = 0;
        }
        else min = max - m;

        while(min <= max) {
            binaryCheck();
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void binaryCheck() {
        middle = (min + max) / 2;
        long sum = 0;
        for (long tree : trees) {
            if (tree - middle > 0)
                sum += tree - middle;
        }
        if (sum >= m) {
            min = middle + 1;
        }
        else {
            max = middle - 1;
        }
    }
}
