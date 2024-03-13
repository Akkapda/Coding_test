import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long sum = 0, min = 0, max, middle;
    static int[] lessons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가장 긴 영상도 무조건 들어가야하므로 최대값 = min
        // max는 다 다 더한 값으로

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lessons = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            sum += lessons[i];
            if (min < lessons[i]) {
                min = lessons[i];
            }
        }
        max = sum;

        while(min <= max) {
            int temp = 0;
            int cnt = 1;
            middle = (min + max) /2;
            for(int i = 0; i < lessons.length; i++) {
                temp += lessons[i];
                if (temp > middle) {
                    temp = lessons[i];
                    cnt++;
                }
            }
            if (cnt > m) {
                min = middle + 1;
            }
            else max = middle - 1;
        }

        long ans = Math.max(min, middle);

        bw.write(Long.toString(ans));

        br.close();
        bw.flush();
        bw.close();
    }
}
