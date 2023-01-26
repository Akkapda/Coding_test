import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(Binomial_Coef(c, k) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int Binomial_Coef(int c, int k) {
        int temp1 = 1, temp2 = 1, temp3 = 1;
        int num = c - k;
        while(c > 1) {
            temp1 *= c--;
        }
        while(num > 1) {
            temp2 *= num--;
        }
        while(k > 1) {
            temp3 *= k--;
        }

        return temp1 / (temp2 * temp3);
    }
}
