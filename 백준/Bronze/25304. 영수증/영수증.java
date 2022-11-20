import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int price, cnt, sum = 0;
        String str;

        for(int i = 0; i < n; i++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            price = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());

            sum += (price * cnt);
        }

        if(sum == total)
            System.out.println("Yes");
        else System.out.println("No");

        br.close();
    }
}
