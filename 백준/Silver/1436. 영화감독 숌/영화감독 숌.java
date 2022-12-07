import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int i_current = 666;
        String s_Current = Integer.toString(i_current);

        boolean starter = false;

        while (n > 0) {
            starter = Get_Starter(s_Current);

            if (starter) {
                n--;
                i_current++;
                s_Current = Integer.toString(i_current);
            }
            else {
                i_current++;
                s_Current = Integer.toString(i_current);
            }
        }

        System.out.println(i_current - 1);

        br.close();
    }

    public static boolean Get_Starter(String str) {
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '6') {
                cnt++;
            }
            else cnt = 0;

            if (cnt == 3) {
                return true;
            }
        }
        return false;
    }
}
