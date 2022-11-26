import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a1 = 3, b1 = 5, cnt = 0;

        while(n > 0) {
            if (n % b1 == 0) {
                n -= b1;
                cnt++;
            }
            else {
                if ((n % 5) % 3 == 0) {
                    n -= a1;
                    cnt++;
                }
                else {
                    n -= a1;
                    cnt++;
                }

            }
        }

        if (n < 0) {
            System.out.println(-1);
        }
        else System.out.println(cnt);

        br.close();
    }
}
