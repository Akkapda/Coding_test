import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] a = new int[9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        int temp, cnt;
        temp = a[0];
        cnt = 0;

        for(int j = 1; j < 9; j++) {
            if(temp < a[j]) {
                temp = a[j];
                cnt = j;
            }
        }
        System.out.println(a[cnt]);
        System.out.println(cnt+1);
    }
}
