import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        cnt = arith_check(a);

        System.out.println(cnt);
        br.close();
    }
    public static int arith_check(int[] a) {
        int[] num = new int[4];
        int j = 0, cnt = 0;
        int temp;
        for(int i = 0; i < a.length; i++) {
            temp = a[i];
            while(temp > 0) {
                num[j++] = temp % 10;
                temp /= 10;
            }
            j = 0;
            if (a[i] < 100) {
                cnt++;
            }
            else if (a[i] >= 100 && a[i] < 1000){
                if (num[1] - num[0] == num[2] - num[1]) {
                    cnt++;
                }
            }
            else {
                if (num[1] - num[0] == num[2] - num[1] && num[2] - num[1] == num[3] - num[2]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}