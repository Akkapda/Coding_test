import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;
        int c = 0;

        int t = Integer.parseInt(br.readLine());

        a = t / 300;
        t -= a * 300;
        b = t / 60;
        t -= b * 60;
        c = t / 10;
        t -= c * 10;

        if (t > 0) {
            System.out.println(-1);
        } else {
            System.out.println(a + " " + b + " " + c);
        }
    }
}
