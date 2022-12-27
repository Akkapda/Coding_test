import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a, b, c;

        while(true) {
            String str = br.readLine();

            if (str.equals("0 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(str);

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            a = a * a;
            b = b * b;
            c = c * c;

            if (a + b == c) {
                bw.write("right\n");
            }
            else if (a + c == b) {
                bw.write("right\n");
            }
            else if (b + c == a) {
                bw.write("right\n");
            }
            else {
                bw.write("wrong\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
