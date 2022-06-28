import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int b = Integer.parseInt(st.nextToken());

        int[] a = new int[b];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < b; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int temp1, temp2;
        temp1 = a[0];
        temp2 = a[0];

        for(int j = 1; j < b; j++) {
            if (temp1 < a[j]) {
                temp1 = a[j];
            }
            if (temp2 > a[j]) {
                temp2 = a[j];
            }
        }
        System.out.println(temp2 + " " + temp1);

        br.close();

    }
}