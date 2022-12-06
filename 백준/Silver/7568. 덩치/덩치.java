import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] humanInfo = new int[n][2];
        int[] rank = new int[n];

        String str;

        for(int i = 0; i < n; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);

            humanInfo[i][0] = Integer.parseInt(st.nextToken());
            humanInfo[i][1] = Integer.parseInt(st.nextToken());

            rank[i] = 1;
        }

        Give_Rank(humanInfo, rank);

        for(int i = 0; i < rank.length; i++) {
            System.out.printf("%d ", rank[i]);
        }
        br.close();

    }

    public static void Give_Rank(int[][] a, int[] rank) {
        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a.length; j++)
                if(a[i][0] > a[j][0] && a[i][1] > a[j][1])
                    rank[j]++;
    }
}
