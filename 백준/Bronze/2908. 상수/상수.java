import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] a = (str.split(" "));

        int b = Integer.parseInt(a[0]), c = Integer.parseInt(a[1]);
        int temp;
        int[] num = new int[2];


        temp = 0;
        temp += (b % 10) * 100;
        b /= 10;
        temp += (b % 10) * 10;
        b /= 10;
        temp += (b % 10);

        num[0] = temp;

        temp = 0;
        temp += (c % 10) * 100;
        c /= 10;
        temp += (c % 10) * 10;
        c /= 10;
        temp += (c % 10);

        num[1] = temp;

        if (num[0] > num[1]) {
            System.out.println(num[0]);
        }
        else System.out.println(num[1]);

        br.close();
    }
}
