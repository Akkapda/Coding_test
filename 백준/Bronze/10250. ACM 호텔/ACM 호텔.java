import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int h, w, n, x, y;

        String[] str = new String[t];

        for(int i = 0; i < t; i++) {
            str[i] = br.readLine();
        }

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(str[i]);
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());


            if (n % h != 0) {
                x = n / h + 1;
                y = n % h;
            }
            else {
                x = n / h;
                y = h;
            }

            System.out.printf("%d%02d\n", y, x);

            br.close();
        }
    }
}
