import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] packPrice = new int[m];
        int[] singlePrice = new int[m];

        for(int i = 0; i < m; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int pack = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());

            if (pack > single * 6) {
                packPrice[i] = 1001;
                singlePrice[i] = single;
            }
            else {
                packPrice[i] = pack;
                singlePrice[i] = single;
            }
        }
        Arrays.sort(packPrice);
        Arrays.sort(singlePrice);

        int packCnt = n / 6;
        int singleCnt = n % 6;
        int total = 0;

        if (packPrice[0] > singlePrice[0] * 6) {
            total = n * singlePrice[0];
        }
        else {
            if (packPrice[0] < singleCnt * singlePrice[0]) {
                total = (packCnt + 1) * packPrice[0];
            }
            else {
                total = (packCnt * packPrice[0]) + (singleCnt * singlePrice[0]);
            }
        }


        System.out.println(total);
        br.close();
    }
}
