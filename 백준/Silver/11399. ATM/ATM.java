import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(str);

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int time = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                time += a[j];
            }
        }

        System.out.println(time);
        br.close();
    }
}
