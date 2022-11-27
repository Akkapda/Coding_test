import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for(int i = n - 1; i >= 0; i--) {
            if (k / a[i] > 0) {
                cnt += k / a[i];
                k = k % a[i];
            }
            else if (k == 0) {
                break;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
