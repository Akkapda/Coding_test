import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        long total = sum(a);

        System.out.println(total);
        br.close();

    }
    public static long sum(int[] a) {
        long ans = 0;
        for(int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans;
    }
}