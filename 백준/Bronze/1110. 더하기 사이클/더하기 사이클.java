import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b, c, d, com;

        int i = 0;
        com = a;

        while(true) {
            b = a / 10;
            c = a % 10;
            d = (b + c) % 10;

            a = (c * 10) + d;

            i++;

            if (a == com) {
                System.out.println(i);
                break;
            }

        }
        br.close();

    }
}