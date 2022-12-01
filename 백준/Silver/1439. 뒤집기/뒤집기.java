import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int cnt1 = 0, cnt2 = 0;
        char temp = str.charAt(0);

        for(int i = 1; i < str.length(); i++) {
            if (temp != str.charAt(i)) {
                if (temp == '0') {
                    temp = str.charAt(i);
                    cnt1++;
                }
                else {
                    temp = str.charAt(i);
                    cnt2++;
                }
            }
        }
        if (cnt1 > cnt2) {
            System.out.println(cnt1);
        }
        else System.out.println(cnt2);

        br.close();
    }
}
