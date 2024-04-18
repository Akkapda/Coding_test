import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //나누어떨어지는 수 -> n ~ 1까지의 합
        //안나누어 떨어지는 수 -> n - 1 ~ 1까지의 합 (0이면 0)

        int[] remainder = new int[m];
        long sum = 0;
        int zeroCounter = 0;
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            int currentRemainder = (int) (sum % m);
            if (currentRemainder == 0) {
                zeroCounter++;
                answer += zeroCounter;
            } else {
                answer += remainder[currentRemainder];

                remainder[currentRemainder]++;
            }
        }
        System.out.println(answer);
    }
}