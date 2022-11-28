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
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        str = br.readLine();

        st = new StringTokenizer(str);

        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        for(int i = 0; i < b.length; i++) {
            b[i] = binary_search(a, b[i]);
        }

        for(int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        br.close();
    }
    public static int binary_search(int[] a, int n) {
        int low = 0, high = a.length - 1;
        int mid;
        if (n < a[low] || n > a[high]) {
            return 0;
        }

        while (low + 1 < high) {
            mid = (low + high) / 2;
            if (n == a[low] || n == a[high] || n == a[mid]) {
                return 1;
            }
            else if(n > a[low] && n < a[mid]) {
                high = mid;
            }
            else if(n > a[mid] && n < a[high]) {
                low = mid;
            }
        }
        return 0;
    }
}
