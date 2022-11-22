import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] s_ar = str.split(" ");

        int n = 0;
        if (s_ar.length > 0) {
            n = s_ar.length;

            if(s_ar[0] == "") {
                n -= 1;
            }
            System.out.println(n);
        }
        else System.out.printf("0");

        br.close();
    }
}
