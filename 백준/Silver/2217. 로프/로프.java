import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int w = 0;

        for(int i = 0;i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        reverse(a);
        w = a[0];

        for(int i = 1; i < n; i++) {
            if (w < a[i] * (i + 1)) {
                w = a[i] * (i + 1);
            }
        }
        
        System.out.println(w);
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
