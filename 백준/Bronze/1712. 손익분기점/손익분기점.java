import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c;

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //손익분기점을 넘을 수 없는 경우 b가 c보다 크거나 같은 경우
        if (b >= c) {
            System.out.printf("-1");
        }
        //넘을 수 있는 경우
        else {
            int cnt = a / (c - b);
            cnt++;
            System.out.println(cnt);
        }

        br.close();
    }
}
