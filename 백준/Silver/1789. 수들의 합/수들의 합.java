import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long n = 1, sum = 0;

        while (sum <= s) {
            sum += n++;
        }
        if (sum == s) {
            System.out.println(n - 1);
        }
        else System.out.println(n - 2);

        br.close();
    }
}
