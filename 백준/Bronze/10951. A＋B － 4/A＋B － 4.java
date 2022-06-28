import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int A, B;
        String str = null;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            st = new StringTokenizer(str, " ");

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if (A > 0 && B < 10) {
                System.out.println(A + B);
            }
        }
        br.close();
    }
}
