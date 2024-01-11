import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int k, n;
    static long ar[];

    public static void main(String[] args) throws IOException {
        //k와 n 입력
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ar= new long[k];
        long sum = 0;

        //랜선길이 받기
        for (int i = 0; i < k; i++) {
            ar[i] = Long.parseLong(br.readLine());
            sum += ar[i];
        }
        Arrays.sort(ar);

        long left = 1;
        long right = sum / n;
        long mid;

        while(left <= right) {
            mid = (left + right) / 2;
            if(BinarySearchCheck(mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        bw.write(right + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean BinarySearchCheck(long mid) {
        long cnt = 0;
        for(int i = 0 ; i < k ; i++) {
            cnt += ar[i] / mid;
        }
        if(cnt >= n) return true;
        else
            return false;
    }
}