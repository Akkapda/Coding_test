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
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int temp = basket[num1 - 1];
            basket[num1 - 1] = basket[num2 - 1];
            basket[num2 - 1] = temp;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}