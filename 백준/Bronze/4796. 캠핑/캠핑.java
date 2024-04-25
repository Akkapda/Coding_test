import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = 0;
        int p = 0;
        int v = 0;

        StringTokenizer st;
        int caseNum = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            int left = v % p;

            if (left >= l) {
                left = l;
            }

            bw.write("Case " + caseNum++ + ": " + (((v / p) * l) + left) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}