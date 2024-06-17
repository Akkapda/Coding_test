import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        sum = factorial(n);
        System.out.println(sum);
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}