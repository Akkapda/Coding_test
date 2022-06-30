import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int a,b,c,d;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        d = a * b * c;

        String s1 = Integer.toString(d);
        String[] s2 = s1.split("");
        int[] cnt = new int[10];
        int[] ans = {0,0,0,0,0,0,0,0,0,0};

        for(int i = 0; i < cnt.length; i++) {
            cnt[i] = i;
        }

        for(int i = 0; i < cnt.length; i++) {
            for(int j = 0; j < s2.length; j++) {
                if (cnt[i] == Integer.parseInt(s2[j])) {
                    ans[i] = ans[i] + 1;
                }
            }
        }

        for(int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        br.close();

    }
}