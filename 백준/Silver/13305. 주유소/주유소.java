import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] km = new int[n - 1];
        int[] won = new int[n];

        //거리
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int index = 0;
        while(st.hasMoreTokens()) {
            km[index++] = Integer.parseInt(st.nextToken());
        }

        //가격
        str = br.readLine();
        st = new StringTokenizer(str);
        index = 0;
        while(st.hasMoreTokens()) {
            won[index++] = Integer.parseInt(st.nextToken());
        }

        long kmSum = 0, currentWon = won[0];
        int temp = 1;
        long total = 0;

        while (temp <= n) {
            if (temp == n) {
                total += (kmSum * currentWon);
                break;
            }
            else if (won[temp] < currentWon && temp < n) {
                kmSum += km[temp - 1];
                total += (kmSum * currentWon);
                kmSum = 0;
                currentWon = won[temp++];
            }
            else if (temp < n){
                kmSum += km[temp - 1];
                temp++;
            }
            else {
                kmSum += km[temp - 1];
            }
        }

        System.out.println(total);

        br.close();
    }
}
