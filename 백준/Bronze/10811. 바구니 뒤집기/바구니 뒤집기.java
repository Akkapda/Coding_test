import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n];

        for(int i = 0; i < n; i++) {
            basket[i] = i + 1;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            for(int j = 0; j < (right - left) / 2 + 1; j++) {
                int temp = basket[right - 1 - j];
                basket[right - 1 - j] = basket[left - 1 + j];
                basket[left - 1 + j] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}