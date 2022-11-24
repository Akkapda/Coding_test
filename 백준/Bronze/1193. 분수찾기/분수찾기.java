import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //분모 a, 분자 b
        int a = 1, b = 1;

        if (n == 1) {
            System.out.printf("%d/%d\n", b, a);
        }
        else if (n == 2) {
            System.out.printf("%d/%d\n", b, a + 1);
        }
        else {
            for(int i = 2; i < n + 1; i++) {
                if (b == 1) {
                    a++;
                    while(i < n && a != 1) {
                        a--;
                        b++;
                        i++;
                    }
                }
                else if (a == 1) {
                    b++;
                    while(i < n && b != 1) {
                        a++;
                        b--;
                        i++;
                    }
                }
            }
            System.out.printf("%d/%d\n", b, a);
        }
        br.close();
    }
}
