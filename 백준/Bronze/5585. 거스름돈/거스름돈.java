import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;

        int pay = 1000 - Integer.parseInt(br.readLine());

        a = pay / 500;
        pay -= a * 500;
        b = pay / 100;
        pay -= b * 100;
        c = pay / 50;
        pay -= c * 50;
        d = pay / 10;
        pay -= d * 10;
        e = pay / 5;
        pay -= e * 5;
        f = pay / 1;
        pay -= f * 1;

        System.out.println(a+b+c+d+e+f);
    }
}
