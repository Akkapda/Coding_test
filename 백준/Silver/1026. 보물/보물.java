import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int sum = 0;

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        for(int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        str = br.readLine();
        st = new StringTokenizer(str);

        for(int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        reverse(b);

        for(int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }

        System.out.println(sum);

        br.close();
    }
    public static void reverse(int[] a) {
        Arrays.sort(a);
        int temp;
        for(int i = 0; i < a.length / 2; i++) {
            temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }
}
